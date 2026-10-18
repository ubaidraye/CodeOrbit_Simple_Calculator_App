package com.raye.codeorbit_calculator_app.model

sealed interface CalculatorAction {
    data class Number(val number: Int) : CalculatorAction
    data class Operation(val operation: CalculatorOperation) : CalculatorAction

    data object Clear : CalculatorAction
    data object Delete : CalculatorAction
    data object Decimal : CalculatorAction
    data object Calculate : CalculatorAction
    data object ToggleSign : CalculatorAction
    data object Percent : CalculatorAction
}
