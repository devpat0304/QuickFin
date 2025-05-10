# 💸 QuickFin


An **interactive Android-based financial calculator app** built using **Java**, **Jetpack Compose**, and **Material Design 3 (Material You)**. This project was developed as part of **CSE 3310: Fundamentals of Software Engineering** at **The University of Texas at Arlington** 🎓 by Group 6: *Money Masters*.

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
