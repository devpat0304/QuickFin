# 💸 QuickFin


An **interactive Android-based financial calculator app** built using **Java** and **Koitlin** on Android Studio. This project was developed as part of **CSE 3310: Fundamentals of Software Engineering** at **The University of Texas at Arlington** 🎓 by Group 6: *Money Masters*.

The **QuickFin** application helps users make fast, informed financial decisions by offering six real-world calculators within a single mobile interface. From tipping at a restaurant to estimating mortgage payments, QuickFin empowers users with accurate, on-demand tools that are neatly categorized, easy to navigate, and visually cohesive across devices.

Designed following **Agile methodology** in three iterative development cycles, QuickFin highlights key software engineering principles such as **modularity**, **reusability**, **scalability**, and **user-centered design**. Each calculator is implemented as its own activity and seamlessly integrated into the main menu screen using **Material navigation** principles.

---

## 🔧 Key Features

- 🧮 **Six fully functional financial tools:**
  - Tip Calculator
  - Mortgage Calculator
  - Currency Converter
  - Discount Calculator
  - Investment Return Calculator
  - Savings Advisor
- ✨ **Modern Android UI** using Jetpack Compose and Material Design 3
- 🧭 **Central main menu** with intuitive buttons and navigation
- 📱 **Fully mobile responsive** with support for multiple screen densities and resolutions
- 📦 **Modular architecture** with separated UI, logic, and theme files
- 🛠️ Built using **Kotlin DSL for Gradle**, AndroidX, and Compose runtime components
- ✅ Includes unit and instrumented tests using `JUnit` and Android Test framework

---


## 📊 Financial Calculators Breakdown

QuickFin includes six practical financial tools, each designed to address specific day-to-day financial needs. Click on each calculator below to view its purpose, inputs, and expected output.

<details>
  <summary>💸 Tip Calculator</summary>

**Purpose:**  
Helps users calculate a fair tip based on their bill and preferred tip percentage. Useful for dining out, group meals, or splitting bills.

**Inputs:**
- Total bill amount
- Tip percentage (e.g., 15%, 18%, 20%)
- Number of people splitting the bill

**Outputs:**
- Total tip amount
- Tip per person
- Final bill total including tip
- Amount owed per person

</details>

<details>
  <summary>🏡 Mortgage Calculator</summary>

**Purpose:**  
Estimates a user's monthly mortgage payment, giving insight into long-term home loan affordability.

**Inputs:**
- Principal loan amount
- Annual interest rate
- Loan term (in years)

**Outputs:**
- Monthly mortgage payment
- Total amount paid over the loan period
- Total interest paid

</details>

<details>
  <summary>💱 Currency Converter</summary>

**Purpose:**  
Converts a specified amount from one currency to another based on a pre-set or real-time exchange rate.

**Inputs:**
- Source currency (e.g., USD)
- Target currency (e.g., EUR)
- Amount to convert

**Outputs:**
- Converted amount in the target currency
- Conversion rate used (static or real-time)

</details>

<details>
  <summary>🏷️ Discount Calculator</summary>

**Purpose:**  
Calculates final price after applying a discount — helpful for shopping deals, sales, and budgeting.

**Inputs:**
- Original price of item
- Discount percentage

**Outputs:**
- Discount amount
- Final price after discount
- Total savings

</details>

<details>
  <summary>📈 Investment Return Calculator</summary>

**Purpose:**  
Estimates the future value of an investment using interest compounding over time.

**Inputs:**
- Initial investment amount (principal)
- Annual interest rate (percentage)
- Investment duration (in years)

**Outputs:**
- Total future value of the investment
- Interest earned over the period

</details>

<details>
  <summary>🏦 Savings Advisor</summary>

**Purpose:**  
Helps users determine how much to save monthly to meet a future financial goal.

**Inputs:**
- Savings goal (target amount)
- Timeframe (months)
- Optional starting amount

**Outputs:**
- Monthly savings needed to reach goal
- Optional projection with existing savings included

</details>


## 📚 This Project Demonstrates:

- 🧱 Component-based screen architecture using Compose functions
- 🎨 Custom Material You themes (colors, typography, surface styling)
- 📲 Event-driven user interaction and navigation between activities
- 🧪 Integrated testing setup (JVM and device-based)
- ⚙️ Kotlin-based Gradle configuration and dependency management
- 🔁 Agile development practices (iterative planning, UML diagrams, and traceability)


Even as a mobile app, **QuickFin** captures the educational intent of classical desktop applications by exposing students to **end-to-end application development** — from UI prototyping and Java logic to test automation and Gradle build systems — all in the context of practical, everyday financial decision-making 💰.

---


## 📂 Project Structure

The QuickFin project is organized into a modular Android project with the following core components:

```
QuickFin-main/
├── RSSReader2/ # Main Android Studio project root
│   ├── .idea/ # IntelliJ/Android Studio configuration files
│   ├── app/ # Application module
│   │   ├── src/
│   │   │   ├── main/
│   │   │   │   ├── java/com/example/rssreader/
│   │   │   │   │   ├── MainActivity.kt
│   │   │   │   │   ├── Color.kt, Theme.kt, Type.kt
│   │   │   │   ├── res/
│   │   │   │   │   ├── layout/, values/, drawable/, mipmap/
│   │   │   │   ├── AndroidManifest.xml
│   │   ├── build.gradle.kts
│   │   ├── proguard-rules.pro
│   ├── gradle/ # Gradle wrapper and config
│   │   ├── wrapper/
│   │   │   ├── gradle-wrapper.jar
│   │   │   ├── gradle-wrapper.properties
│   │   ├── libs.versions.toml
│   ├── build.gradle.kts
│   ├── settings.gradle.kts
│   └── README.md # This documentation file
```

> 💡 Each calculator screen is implemented in its own `Activity` or `Composable`, allowing modular development and testing. Gradle Kotlin DSL enables more readable build configuration.
"""
> 

## 🚀 Getting Started

This section provides instructions for setting up the **QuickFin** Android application locally using Android Studio.

### ✅ Prerequisites

Before you begin, ensure you have the following installed:

- 📦 **Android Studio** (Electric Eel or newer)
- ☕ **Java Development Kit (JDK)** 17 or higher
- 🟣 **Kotlin** 1.8+
- ⚙️ **Gradle** 8.0+ (Handled automatically via Android Studio)
- 📱 An Android emulator or physical device for testing

---

### 📥 Installation

To clone the repository and open the project:

```bash
git clone https://github.com/your-username/QuickFin.git
cd QuickFin-main/RSSReader2
```

Open the `RSSReader2` folder in **Android Studio** as a new project.

---

### ▶️ Build & Run

Once inside Android Studio:

1. Click **"Build > Make Project"** or press `Ctrl + F9` to compile the project.
2. Connect an Android device or launch an emulator.
3. Click the green **Run** arrow (`Shift + F10`) to deploy the app.

---

## 🛠️ Technologies Used

QuickFin was developed using modern Android technologies and best practices to ensure performance, modularity, and scalability.

| Category              | Tools / Technologies                               |
|-----------------------|----------------------------------------------------|
| 👨‍💻 Programming       | Java, Kotlin                                        |
| 📱 Mobile Platform    | Android (SDK 33+), Android Studio                  |
| 🎨 UI Framework       | Jetpack Compose, Material Design 3 (Material You)  |
| ⚙️ Build Tools        | Gradle (Kotlin DSL), ProGuard                      |
| 🧪 Testing Frameworks | JUnit, Android Instrumentation (Espresso)          |
| 📦 Dependency Mgmt    | Gradle Wrapper, libs.versions.toml                 |

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/android-%233DDC84.svg?style=for-the-badge&logo=android&logoColor=white)
![Gradle](https://img.shields.io/badge/gradle-%2302303A.svg?style=for-the-badge&logo=gradle&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpack-compose&logoColor=white)
![JUnit](https://img.shields.io/badge/junit-%2325A162.svg?style=for-the-badge&logo=junit5&logoColor=white)


The application should launch on the selected device, allowing you to explore all built-in financial tools from the main menu.

# 📚 QuickFin Documentation

This section summarizes formal documentation from the Final Report and Presentation. It includes diagrams, use cases, requirement traceability, and team insights developed throughout the semester.

---

## 📌 Project Summary

QuickFin is a mobile financial toolkit designed to help users quickly and accurately perform everyday financial calculations.

It includes tools for:
- Tipping at restaurants
- Estimating mortgage payments
- Converting currencies
- Calculating investment growth
- Applying discounts
- Advising on savings strategy

The app was developed by **Group 6: Money Masters** using Agile methodology over 3 iterations, covering all phases of the software development lifecycle.

---

## 📋 Requirements and Use Cases

<details>
<summary><strong>✅ Functional Requirements</strong></summary>

| ID  | Requirement Description                                                                 |
|-----|------------------------------------------------------------------------------------------|
| R1  | View the home menu with all financial calculator options                                |
| R2  | Calculate tip amount with total bill                                                     |
| R3  | Calculate monthly mortgage payments                                                      |
| R4  | Convert between two currencies                                                           |
| R5  | Calculate future investment value using compound interest                               |
| R6  | Determine final price after discount                                                     |
| R7  | Receive personalized savings advice based on income and expenses                        |

</details>

<details>
<summary><strong>📌 Use Case Summary</strong></summary>

Each calculator corresponds to a specific use case (UC):

- **UC1:** Home Menu Navigation  
- **UC2:** Tip Calculator  
- **UC3:** Mortgage Calculator  
- **UC4:** Currency Converter  
- **UC5:** Investment Return  
- **UC6:** Discount Calculator  
- **UC7:** Savings Advisor  

</details>

<details>
<summary><strong>📈 Increment Planning</strong></summary>

| Use Case | Assigned To          | Iteration(s) | Effort (Person-Weeks) |
|----------|----------------------|--------------|------------------------|
| UC1      | Dev Patel            | 2            | 2                      |
| UC2      | Yahia Elsaad         | 1, 2         | 2                      |
| UC3      | Jeffery, Ore         | 1, 2, 3      | 3                      |
| UC4      | Ore, Dev             | 1, 2         | 2                      |
| UC5      | Mohamad, Yahia       | 1, 2         | 3                      |
| UC6      | Mohamad              | 2            | 2                      |
| UC7      | Mohamad, Dev, Yahia  | 2            | 2                      |

</details>

---

## 🔄 Expanded Use Cases

<details>
<summary><strong>💸 EUC2: Tip Calculator</strong></summary>

- Input: Bill amount and tip %
- Output: Tip amount, total cost, per-person split
- Non-trivial logic: Input validation, tip presets, custom tip handling

</details>

<details>
<summary><strong>🏡 EUC3: Mortgage Calculator</strong></summary>

- Input: Loan amount, down payment, APR, term
- Output: Monthly payment, total paid, total interest
- Non-trivial logic: Validating down payment < loan, using amortization formula

</details>

<details>
<summary><strong>💱 EUC4: Currency Converter</strong></summary>

- Input: Source currency, target currency, amount
- Output: Converted value
- Non-trivial logic: Apply real-time exchange rate (static in demo)

</details>

<details>
<summary><strong>📈 EUC5: Investment Return</strong></summary>

- Input: Principal, interest rate, duration
- Output: Future value
- Formula: Compound interest

</details>

<details>
<summary><strong>🏷️ EUC6: Discount Calculator</strong></summary>

- Input: Original price, discount %
- Output: Final price, savings
- Logic: Validate price/percentage

</details>

<details>
<summary><strong>🏦 EUC7: Savings Advisor</strong></summary>

- Input: Monthly income, savings goal, list of expenses
- Output: Recommendation message if savings target is met
- Non-trivial logic: Expense summation, delta analysis with savings goal

</details>

---

## 📊 Diagrams and Visuals

<details>
<summary><strong>🧠 Domain Model Diagram</strong></summary>

Diagram mapping users, calculators, and financial logic — available in final report PDF.

</details>

<details>
<summary><strong>🔁 Sequence & Class Diagrams</strong></summary>

- **Design Sequence Diagrams:** Tip, Mortgage, Currency Converter  
- **Analysis Sequence Diagrams:** Investment Return, Savings Advisor  
- **Design Class Diagram:** Illustrates structure and relationships

</details>

---

## 🎥 Demo Video

Experience QuickFin in action! Watch our full demonstration, showcasing all six financial calculators and navigation features.

[![QuickFin Demo](https://img.youtube.com/vi/_DCBa3raniM/0.jpg)](https://youtu.be/_DCBa3raniM)

🔗 [Click here to watch on YouTube](https://youtu.be/_DCBa3raniM)

> This video walkthrough was part of our final presentation for CSE 3310 at The University of Texas at Arlington. It demonstrates the app’s UI, functionality, and real-time usage across various financial tools.



