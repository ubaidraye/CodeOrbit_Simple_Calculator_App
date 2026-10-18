# CodeOrbit Calculator App 🧮

A modern, responsive, and robust Calculator Android application built with **Kotlin**, **Jetpack
Compose**, and **Material Design 3** as part of the **CodeOrbitTech Internship Task**.

---

## 📱 Features

- ➕ **Addition, Subtraction, Multiplication & Division**: Core arithmetic operations with clean
  order-of-operation handling.
- 🚫 **Invalid Input & Error Handling**: Gracefully handles division by zero
  (`Cannot divide by zero`) without crashing.
- 🔣 **Advanced Quick Actions**:
    - **Percent (`%`)**: Converts inputs to percentage values.
    - **Sign Toggle (`±`)**: Easily switch between positive and negative numbers.
    - **Clear (`AC`) & Backspace (`⌫`)**: Effortless correction of inputs.
    - **Decimal Point (`.`)**: High-precision decimal calculations.
- 🎨 **Material 3 Design**: Responsive button grid with clear visual hierarchy and dark/light theme
  support.
- 🧪 **Unit Tested**: Core calculator logic is thoroughly verified with automated unit tests (JUnit
  4).

---

## 🛠️ Technologies Used

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose & Material Design 3
- **Architecture**: MVVM (Model-View-ViewModel) + StateFlow
- **Build System**: Gradle Version Catalogs (KTS)
- **Testing**: JUnit 4 (Unit Testing)

---

## 🚀 Getting Started & Setup Instructions

### Prerequisites

- **Android Studio**: Ladybug / Jellyfish (2024.1+) or newer.
- **JDK**: JDK 11 or higher.
- **Android SDK**: Min SDK 24 (Android 7.0) / Target SDK 35/37.

### Installation Steps

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/ubaidraye/CodeOrbit_Simple_Calculator_App.git
   cd CodeOrbit_Calculator_App
   ```
2. **Open in Android Studio**:
    - Open Android Studio $\rightarrow$ `File` $\rightarrow$ `Open...` $\rightarrow$ Select the
      cloned project folder.
3. **Sync & Build**:
    - Allow Gradle to sync dependencies.
    - Run unit tests to verify calculator engine logic:
      ```bash
      ./gradlew test
      ```
4. **Run on Device / Emulator**:
    - Select your target device/emulator and press **Run** (`Shift + F10`).

---

## 🔗 Repository Link

- **GitHub Repository**: [CodeOrbit Calculator App Repository](https://github.com/ubaidraye/CodeOrbit_Simple_Calculator_App)