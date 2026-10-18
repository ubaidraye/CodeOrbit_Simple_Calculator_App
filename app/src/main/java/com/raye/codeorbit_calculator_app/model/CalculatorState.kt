package com.raye.codeorbit_calculator_app.model

data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    val operation: CalculatorOperation? = null,
    val displayText: String = "0",
    val errorMessage: String? = null
)
