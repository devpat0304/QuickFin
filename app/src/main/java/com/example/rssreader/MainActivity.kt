package com.example.rssreader

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rssreader.ui.theme.RSSReaderTheme



import com.example.rssreader.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val features = listOf(
            "Tip Calculator",
            "Mortgage Calculator",
            "Currency Converter",
            "Discount Calculator",
            "Savings Advisor",
            "Investment Return Calculator"
        )

        setContent {
            RSSReaderTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .padding(vertical = 16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Display logo at the top
                        Image(
                            painter = painterResource(id = R.drawable.icon), // Replace "icon" with the actual logo file name
                            contentDescription = "App Logo",
                            modifier = Modifier
                                .size(200.dp)
                                .padding(bottom = 1.dp)
                        )

                        // Display app title
                        Text(
                            text = "QuickFin",
                            fontSize = 32.sp,
                            color = Color.Green,
                            fontFamily = FontFamily.Serif,
                                    // Use Serif font
                            fontWeight = FontWeight.Bold, // Make it bold
                            modifier = Modifier
                                .padding(0.5.dp)
                        )
                        Text(
                            text = "Your favorite financial tool", // New tagline
                            fontSize = 30.sp,
                            color = Color(0xFF006400),
                            fontFamily = FontFamily.Cursive,
                            modifier = Modifier.padding(top = 8.dp) // Adds spacing from the title
                        )

                        // Display features in a list
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.spacedBy(2.dp),
                            contentPadding = PaddingValues(horizontal = 0.5.dp)
                        ) {
                            items(features) { item ->
                                ListItem(name = item) {
                                    when (item) {
                                        "Tip Calculator" -> startActivity(Intent(this@MainActivity, TipCalculatorActivity::class.java))
                                        "Mortgage Calculator" -> startActivity(Intent(this@MainActivity, MortgageCalculatorActivity::class.java))
                                        "Currency Converter" -> startActivity(Intent(this@MainActivity, CurrencyConverterActivity::class.java))
                                        "Discount Calculator" -> startActivity(Intent(this@MainActivity, DiscountCalculatorActivity::class.java))
                                        "Investment Return Calculator" -> startActivity(Intent(this@MainActivity, InvestmentReturnCalculatorActivity::class.java))
                                        "Savings Advisor" -> startActivity(Intent(this@MainActivity, SavingsAdvisorActivity::class.java))
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun ListItem(name: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        // Centering the text inside the card
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            contentAlignment = Alignment.Center // Center the text
        ) {
            Text(
                text = name,
                fontSize = 20.sp, // Change font size here
                fontWeight = FontWeight.Bold, // Make the text bold (optional)
                color = Color.Black // Set the color of the text
            )
        }
    }
}


// Tip Calculator Activity
@OptIn(ExperimentalMaterial3Api::class)
class TipCalculatorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RSSReaderTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Tip Calculator") },
                            navigationIcon = {
                                IconButton(onClick = { finish() }) { // Go back to previous screen
                                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    TipCalculatorScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun TipCalculatorScreen(modifier: Modifier = Modifier) {
    var billAmount by remember { mutableStateOf("") }
    var tipAmount by remember { mutableStateOf(0.0) }
    var totalAmount by remember { mutableStateOf(0.0) }
    var customTipPercentage by remember { mutableStateOf("") }
    var selectedTipPercentage by remember { mutableStateOf(0.0) }
    var generosityMessage by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) { Text(
        text = "Quick Tips Made Easy",
        color = Color(0xFF006400),
        fontFamily = FontFamily.Cursive,
        fontSize = 30.sp,
        modifier = Modifier.padding(top = 20.dp)
    )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Input: Bill Amount
            OutlinedTextField(
                value = billAmount,
                onValueChange = { input ->
                    billAmount = input
                    errorMessage = ""
                    generosityMessage = ""
                },
                label = { Text("Enter Bill Amount") },
                modifier = Modifier.fillMaxWidth(),
                isError = errorMessage.isNotEmpty()
            )

            // Display error message if any
            if (errorMessage.isNotEmpty()) {
                Text(
                    text = errorMessage,
                    color = Color.Red,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            // Title: Select a Tip Percentage
            Text(
                text = "Select a Tip Percentage",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Tip Percentage Boxes
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // First Row: 15% and 18%
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    TipBox(
                        label = "15%",
                        subLabel = "Good",
                        percentage = 15,
                        billAmount = billAmount,
                        isSelected = selectedTipPercentage == 15.0,
                        onTipSelected = { selectedTipPercentage = it }
                    )
                    TipBox(
                        label = "18%",
                        subLabel = "Great",
                        percentage = 18,
                        billAmount = billAmount,
                        isSelected = selectedTipPercentage == 18.0,
                        onTipSelected = { selectedTipPercentage = it }
                    )
                }

                // Second Row: 20% and Custom
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    TipBox(
                        label = "20%",
                        subLabel = "Amazing",
                        percentage = 20,
                        billAmount = billAmount,
                        isSelected = selectedTipPercentage == 20.0,
                        onTipSelected = { selectedTipPercentage = it }
                    )
                    CustomTipBox(
                        customTipPercentage = customTipPercentage,
                        isSelected = selectedTipPercentage > 0.0 && selectedTipPercentage != 15.0 && selectedTipPercentage != 18.0 && selectedTipPercentage != 20.0,
                        onValueChange = { customTipPercentage = it },
                        onCustomTipSelected = { selectedTipPercentage = it }
                    )
                }
            }

            // Calculate Button
            Button(
                onClick = {
                    val bill = billAmount.toDoubleOrNull()
                    if (bill == null || bill <= 0) {
                        errorMessage = "Please enter a valid positive bill amount."
                        tipAmount = 0.0
                        totalAmount = 0.0
                        return@Button
                    }
                    val customTip = customTipPercentage.toDoubleOrNull()
                    if (selectedTipPercentage == 0.0 && (customTip == null || customTip <= 0)) {
                        errorMessage = "Please select a valid tip percentage."
                        return@Button
                    }
                    errorMessage = ""
                    tipAmount = bill * (selectedTipPercentage / 100)
                    totalAmount = bill + tipAmount
                    generosityMessage = if (selectedTipPercentage >= 20) {
                        "Wow, you are being generous!"
                    } else {
                        ""
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4CAF50),
                    contentColor = Color.White
                )
            ) {
                Text("Calculate")
            }

            // Generosity Message
            if (generosityMessage.isNotEmpty()) {
                Text(
                    text = generosityMessage,
                    color = Color.Green,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            // Results
            if (tipAmount > 0 || totalAmount > 0) {
                ResultsCard(tipAmount = tipAmount, totalAmount = totalAmount)
            }
        }

        // App Logo at the Bottom
        Image(
            painter = painterResource(id = R.drawable.icon),
            contentDescription = "App Logo",
            modifier = Modifier
                .size(100.dp)
                .padding(bottom = 16.dp)
        )
    }
}


@Composable
fun TipBox(
    label: String,
    subLabel: String,
    percentage: Int,
    billAmount: String,
    isSelected: Boolean, // Highlight if true
    onTipSelected: (Double) -> Unit
) {
    Card(
        modifier = Modifier
            .size(120.dp) // Larger box size
            .clickable {
                val bill = billAmount.toDoubleOrNull() ?: 0.0
                onTipSelected(percentage.toDouble())
            },
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) Color.Red else Color(0xFF4CAF50) // Red for selected
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = label, fontSize = 20.sp, color = Color.White)
            Text(text = subLabel, fontSize = 14.sp, color = Color.White)
        }
    }
}

@Composable
fun CustomTipBox(
    customTipPercentage: String,
    isSelected: Boolean,
    onValueChange: (String) -> Unit,
    onCustomTipSelected: (Double) -> Unit
) {
    Card(
        modifier = Modifier
            .size(120.dp)
            .clickable {
                // Optional: Ensure the custom tip is selected on click
                val customTip = customTipPercentage.toDoubleOrNull() ?: 0.0
                onCustomTipSelected(customTip)
            },
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) Color.Red else Color(0xFF4CAF50) // Red for selected
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = customTipPercentage,
                onValueChange = {
                    onValueChange(it) // Update the input value dynamically
                    val customTip = it.toDoubleOrNull() ?: 0.0
                    onCustomTipSelected(customTip) // Dynamically update selectedTipPercentage
                },
                label = { Text("Custom %") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


@Composable
fun ResultsCard(tipAmount: Double, totalAmount: Double) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Tip Amount",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF4CAF50)
                ),
                fontSize = 18.sp
            )
            Text(
                text = "$${"%.2f".format(tipAmount)}",
                fontSize = 16.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Total Bill Amount",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2196F3)
                ),
                fontSize = 18.sp
            )
            Text(
                text = "$${"%.2f".format(totalAmount)}",
                fontSize = 16.sp,
                color = Color.Black
            )
        }
    }
}




// Mortgage Calculator Activity
@OptIn(ExperimentalMaterial3Api::class)
class MortgageCalculatorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RSSReaderTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Mortgage Calculator") },
                            navigationIcon = {
                                IconButton(onClick = { finish() }) { // Back button
                                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    MortgageCalculatorScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MortgageCalculatorScreen(modifier: Modifier = Modifier) {
    var loanAmount by remember { mutableStateOf("") }
    var downPayment by remember { mutableStateOf("") }
    var interestRate by remember { mutableStateOf("") }
    var loanTerm by remember { mutableStateOf("") }
    var monthlyPayment by remember { mutableStateOf(0.0) }

    // Error states
    var loanAmountError by remember { mutableStateOf(false) }
    var downPaymentError by remember { mutableStateOf(false) }
    var interestRateError by remember { mutableStateOf(false) }
    var loanTermError by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) { Text(
            text = "Unlock Your Mortgage Potential",
            color = Color(0xFF006400),
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
            // Input: Loan Amount
            OutlinedTextField(
                value = loanAmount,
                onValueChange = {
                    loanAmount = it
                    loanAmountError = !isValidPositiveNumber(it)
                },
                label = { Text("Enter Loan Amount") },
                isError = loanAmountError,
                modifier = Modifier.fillMaxWidth()
            )
            if (loanAmountError) {
                Text(
                    text = "Please enter a valid positive number",
                    color = Color.Red,
                    fontSize = 14.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
            }

            // Input: Down Payment
            OutlinedTextField(
                value = downPayment,
                onValueChange = {
                    downPayment = it
                    downPaymentError = !isValidPositiveNumber(it)
                },
                label = { Text("Enter Down Payment") },
                isError = downPaymentError,
                modifier = Modifier.fillMaxWidth()
            )
            if (downPaymentError) {
                Text(
                    text = "Please enter a valid positive number",
                    color = Color.Red,
                    fontSize = 14.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
            }

            // Input: Interest Rate
            OutlinedTextField(
                value = interestRate,
                onValueChange = {
                    interestRate = it
                    interestRateError = !isValidPositiveNumber(it)
                },
                label = { Text("Enter Annual Interest Rate (%)") },
                isError = interestRateError,
                modifier = Modifier.fillMaxWidth()
            )
            if (interestRateError) {
                Text(
                    text = "Please enter a valid positive number",
                    color = Color.Red,
                    fontSize = 14.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
            }

            // Input: Loan Term
            OutlinedTextField(
                value = loanTerm,
                onValueChange = {
                    loanTerm = it
                    loanTermError = !isValidPositiveNumber(it)
                },
                label = { Text("Enter Loan Term (Years)") },
                isError = loanTermError,
                modifier = Modifier.fillMaxWidth()
            )
            if (loanTermError) {
                Text(
                    text = "Please enter a valid positive number",
                    color = Color.Red,
                    fontSize = 14.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
            }

            // Calculate Button
            Button(
                onClick = {
                    if (!loanAmountError && !downPaymentError && !interestRateError && !loanTermError) {
                        val principal = (loanAmount.toDoubleOrNull() ?: 0.0) - (downPayment.toDoubleOrNull() ?: 0.0)
                        val annualRate = (interestRate.toDoubleOrNull() ?: 0.0) / 100
                        val monthlyRate = annualRate / 12
                        val months = (loanTerm.toDoubleOrNull() ?: 0.0) * 12
                        monthlyPayment = if (monthlyRate > 0) {
                            (principal * monthlyRate * Math.pow(1 + monthlyRate, months)) / (Math.pow(1 + monthlyRate, months) - 1)
                        } else {
                            principal / months
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(top =20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4CAF50), // Green button
                    contentColor = Color.White
                )
            ) {
                Text("Calculate", fontSize = 18.sp)
            }

            // Results Section
            if (monthlyPayment > 0) {
                ResultsCard(label = "Monthly Payment", value = monthlyPayment)
            }
        }

        // App Logo at the Bottom
        Image(
            painter = painterResource(id = R.drawable.icon), // Replace with your logo resource
            contentDescription = "App Logo",
            modifier = Modifier
                .size(100.dp)
                .padding(bottom = 16.dp)
        )
    }
}

// Helper Function for Validation
fun isValidPositiveNumber(input: String): Boolean {
    return input.isEmpty() || input.toDoubleOrNull()?.let { it > 0 } == true
}

@Composable
fun ResultsCard(label: String, value: Double) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF4CAF50)
                ),
                fontSize = 18.sp
            )
            Text(
                text = "$${"%.2f".format(value)}",
                fontSize = 16.sp,
                color = Color.Black
            )
        }
    }
}


// Currency Converter Activity
class CurrencyConverterActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RSSReaderTheme {
                Scaffold {
                    CurrencyConverterScreen()
                }
            }
        }
    }
}

@Composable
fun CurrencyConverterScreen() {
    val currencies = listOf(
        "US Dollar", "Euros", "Pesos", "Rupee", "Pounds Sterling",
        "Yuan", "Saudi Riyal", "Russian Ruble", "Japanese Yen", "UAE Dirham"
    )
    var amount by remember { mutableStateOf("") }
    var conversionRate by remember { mutableStateOf("") }
    var fromCurrency by remember { mutableStateOf(currencies[0]) }
    var toCurrency by remember { mutableStateOf(currencies[1]) }
    var convertedAmount by remember { mutableStateOf(0.0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Currency Converter", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "From")
        DropdownMenu(selectedItem = fromCurrency, items = currencies) { selected ->
            fromCurrency = selected
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "To")
        DropdownMenu(selectedItem = toCurrency, items = currencies) { selected ->
            toCurrency = selected
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Enter Amount") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))



        Button(
            onClick = {
                convertedAmount = (amount.toDoubleOrNull() ?: 0.0) * (conversionRate.toDoubleOrNull() ?: 1.0)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Convert")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Converted Amount: $${"%.2f".format(convertedAmount)}")
    }
}

@Composable
fun DropdownMenu(selectedItem: String, items: List<String>, onItemSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = true }
            .padding(vertical = 8.dp)
    ) {
        Text(text = selectedItem, modifier = Modifier.padding(8.dp))
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = { Text(text = item) },
                    onClick = {
                        onItemSelected(item)
                        expanded = false
                    }
                )
            }
        }
    }
}

//investment calculator activity
@OptIn(ExperimentalMaterial3Api::class)
class InvestmentReturnCalculatorActivity : ComponentActivity() { // Renamed class
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RSSReaderTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Investment Calculator") },
                            navigationIcon = {
                                IconButton(onClick = { finish() }) { // Back button
                                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    InvestmentScreen(modifier = Modifier.padding(innerPadding)) // Renamed function
                }
            }
        }
    }
}

@Composable
fun InvestmentScreen(modifier: Modifier = Modifier) { // Renamed function
    var initialInvestment by remember { mutableStateOf("") }
    var annualReturnRate by remember { mutableStateOf("") }
    var investmentDuration by remember { mutableStateOf("") }
    var futureValue by remember { mutableStateOf(0.0) }
    var impressiveGrowthMessage by remember { mutableStateOf("") }

    // Error states
    var initialInvestmentError by remember { mutableStateOf(false) }
    var annualReturnRateError by remember { mutableStateOf(false) }
    var investmentDurationError by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header
            Text(
                text = "Forecast Your Financial Growth",
                color = Color(0xFF006400),
                fontFamily = FontFamily.Cursive,
                fontSize = 30.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Input: Initial Investment
            OutlinedTextField(
                value = initialInvestment,
                onValueChange = {
                    initialInvestment = it
                    initialInvestmentError = !isaValidPositiveInput(it) // Renamed validation function
                },
                label = { Text("Enter Initial Investment") },
                isError = initialInvestmentError,
                modifier = Modifier.fillMaxWidth()
            )
            if (initialInvestmentError) {
                Text(
                    text = "Please enter a valid positive number",
                    color = Color.Red,
                    fontSize = 14.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
            }

            // Input: Annual Return Rate
            OutlinedTextField(
                value = annualReturnRate,
                onValueChange = {
                    annualReturnRate = it
                    annualReturnRateError = !isaValidPositiveInput(it) // Renamed validation function
                },
                label = { Text("Enter Annual Return Rate (%)") },
                isError = annualReturnRateError,
                modifier = Modifier.fillMaxWidth()
            )
            if (annualReturnRateError) {
                Text(
                    text = "Please enter a valid positive number",
                    color = Color.Red,
                    fontSize = 14.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
            }

            // Input: Investment Duration
            OutlinedTextField(
                value = investmentDuration,
                onValueChange = {
                    investmentDuration = it
                    investmentDurationError = !isaValidPositiveInput(it) // Renamed validation function
                },
                label = { Text("Enter Investment Duration (Years)") },
                isError = investmentDurationError,
                modifier = Modifier.fillMaxWidth()
            )
            if (investmentDurationError) {
                Text(
                    text = "Please enter a valid positive number",
                    color = Color.Red,
                    fontSize = 14.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
            }

            // Calculate Button
            Button(
                onClick = {
                    if (!initialInvestmentError && !annualReturnRateError && !investmentDurationError) {
                        val principal = initialInvestment.toDoubleOrNull() ?: 0.0
                        val rate = (annualReturnRate.toDoubleOrNull() ?: 0.0) / 100
                        val time = investmentDuration.toDoubleOrNull() ?: 0.0
                        futureValue = principal * Math.pow(1 + rate, time)

                        // Display message if growth rate exceeds 10% of initial investment
                        impressiveGrowthMessage = if (rate > 0.1) {
                            "Impressive growth rate—you're making your money work hard!"
                        } else {
                            ""
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(top = 20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4CAF50), // Green button
                    contentColor = Color.White
                )
            ) {
                Text("Calculate", fontSize = 18.sp)
            }

            // Impressive Growth Message
            if (impressiveGrowthMessage.isNotEmpty()) {
                Text(
                    text = impressiveGrowthMessage,
                    color = Color.Green,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            // Results Section
            if (futureValue > 0) {
                InvestmentResultsCard(label = "Future Value", value = futureValue) // Renamed function
            }
        }

        // App Logo at the Bottom
        Image(
            painter = painterResource(id = R.drawable.icon), // Replace with your logo resource
            contentDescription = "App Logo",
            modifier = Modifier
                .size(100.dp)
                .padding(bottom = 16.dp)
        )
    }
}

// Helper Function for Validation
fun isaValidPositiveInput(input: String): Boolean { // Renamed function
    return input.isEmpty() || input.toDoubleOrNull()?.let { it > 0 } == true
}

@Composable
fun InvestmentResultsCard(label: String, value: Double) { // Renamed function
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF4CAF50)
                ),
                fontSize = 18.sp
            )
            Text(
                text = "$${"%.2f".format(value)}",
                fontSize = 16.sp,
                color = Color.Black
            )
        }
    }
}

//Discount Calculator Activity
@OptIn(ExperimentalMaterial3Api::class)
class DiscountCalculatorActivity : ComponentActivity() { // Renamed class
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RSSReaderTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Discount Calculator") },
                            navigationIcon = {
                                IconButton(onClick = { finish() }) { // Back button
                                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    DiscountScreen(modifier = Modifier.padding(innerPadding)) // Renamed function
                }
            }
        }
    }
}

@Composable
fun DiscountScreen(modifier: Modifier = Modifier) { // Renamed function
    var originalPrice by remember { mutableStateOf("") }
    var discountPercentage by remember { mutableStateOf("") }
    var discountAmount by remember { mutableStateOf(0.0) }
    var finalPrice by remember { mutableStateOf(0.0) }
    var bigSavingsMessage by remember { mutableStateOf("") }

    // Error states
    var originalPriceError by remember { mutableStateOf(false) }
    var discountPercentageError by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Phrase Header
            Text(
                text = "Calculate Your Discounts Instantly",
                color = Color(0xFF006400),
                fontFamily = FontFamily.Cursive,
                fontSize = 27.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Input: Original Price
            OutlinedTextField(
                value = originalPrice,
                onValueChange = {
                    originalPrice = it
                    originalPriceError = !isValidPositiveInput(it) // Renamed validation function
                },
                label = { Text("Enter Original Price") },
                isError = originalPriceError,
                modifier = Modifier.fillMaxWidth()
            )
            if (originalPriceError) {
                Text(
                    text = "Please enter a valid positive number",
                    color = Color.Red,
                    fontSize = 14.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
            }

            // Input: Discount Percentage
            OutlinedTextField(
                value = discountPercentage,
                onValueChange = {
                    discountPercentage = it
                    discountPercentageError = !isValidPositiveInput(it) // Renamed validation function
                },
                label = { Text("Enter Discount Percentage") },
                isError = discountPercentageError,
                modifier = Modifier.fillMaxWidth()
            )
            if (discountPercentageError) {
                Text(
                    text = "Please enter a valid positive number",
                    color = Color.Red,
                    fontSize = 14.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
            }

            // Calculate Button
            Button(
                onClick = {
                    if (!originalPriceError && !discountPercentageError) {
                        val price = originalPrice.toDoubleOrNull() ?: 0.0
                        val discount = discountPercentage.toDoubleOrNull() ?: 0.0
                        discountAmount = price * (discount / 100)
                        finalPrice = price - discountAmount

                        bigSavingsMessage = if (discount >= 50) {
                            "Wow, you're saving big!"
                        } else {
                            ""
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4CAF50), // Green button
                    contentColor = Color.White
                )
            ) {
                Text("Calculate", fontSize = 18.sp)
            }

            // Big Savings Message
            if (bigSavingsMessage.isNotEmpty()) {
                Text(
                    text = bigSavingsMessage,
                    color = Color.Green,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            // Results Section
            if (discountAmount > 0 || finalPrice > 0) {
                DiscountResultsCard(label = "Discount Amount", value = discountAmount) // Renamed function
                DiscountResultsCard(label = "Final Price", value = finalPrice) // Renamed function
            }
        }

        // App Logo at the Bottom
        Image(
            painter = painterResource(id = R.drawable.icon), // Replace with your logo resource
            contentDescription = "App Logo",
            modifier = Modifier
                .size(100.dp)
                .padding(bottom = 16.dp)
        )
    }
}

// Helper Function for Validation
fun isValidPositiveInput(input: String): Boolean { // Renamed function
    return input.isEmpty() || input.toDoubleOrNull()?.let { it > 0 } == true
}

@Composable
fun DiscountResultsCard(label: String, value: Double) { // Renamed function
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF4CAF50)
                ),
                fontSize = 18.sp
            )
            Text(
                text = "$${"%.2f".format(value)}",
                fontSize = 16.sp,
                color = Color.Black
            )
        }
    }
}



class SavingsAdvisorActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RSSReaderTheme {
                Scaffold {
                    SavingsAdvisorScreen()
                }
            }
        }
    }
}

@Composable
fun SavingsAdvisorScreen() {
    var monthlyIncome by remember { mutableStateOf("") }
    var monthlyExpenses by remember { mutableStateOf("") }
    var targetSavings by remember { mutableStateOf("") }
    var monthlySavingsGoal by remember { mutableStateOf(0.0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Savings Advisor",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = monthlyIncome,
            onValueChange = { monthlyIncome = it },
            label = { Text("Enter Monthly Income") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = monthlyExpenses,
            onValueChange = { monthlyExpenses = it },
            label = { Text("Enter Monthly Expenses") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = targetSavings,
            onValueChange = { targetSavings = it },
            label = { Text("Enter Target Savings Amount") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val income = monthlyIncome.toDoubleOrNull() ?: 0.0
                val expenses = monthlyExpenses.toDoubleOrNull() ?: 0.0
                val savings = targetSavings.toDoubleOrNull() ?: 0.0
                monthlySavingsGoal = income - expenses - savings
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calculate")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Monthly Savings Goal: $${"%.2f".format(monthlySavingsGoal)}")
    }

}