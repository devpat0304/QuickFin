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

---

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

The application should launch on the selected device, allowing you to explore all built-in financial tools from the main menu.

