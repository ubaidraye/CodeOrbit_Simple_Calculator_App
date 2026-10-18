package com.raye.codeorbit_calculator_app.ui

import androidx.lifecycle.ViewModel
import com.raye.codeorbit_calculator_app.model.CalculatorAction
import com.raye.codeorbit_calculator_app.model.CalculatorOperation
import com.raye.codeorbit_calculator_app.model.CalculatorState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.math.BigDecimal
import java.math.RoundingMode

class CalculatorViewModel : ViewModel() {
    private val _state = MutableStateFlow(CalculatorState())
    val state = _state.asStateFlow()

    fun onAction(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Clear -> performClear()
            is CalculatorAction.Delete -> performDelete()
            is CalculatorAction.Calculate -> performCalculation()
            is CalculatorAction.ToggleSign -> performToggleSign()
            is CalculatorAction.Percent -> performPercentage()
        }
    }

    private fun enterNumber(number: Int) {
        val currentState = _state.value
        if (currentState.operation == null) {
            if (currentState.number1.length >= 10) return
            val updatedNumber = currentState.number1 + number
            _state.value = currentState.copy(
                number1 = updatedNumber,
                displayText = updatedNumber,
                errorMessage = null
            )
        } else {
            if (currentState.number2.length >= 10) return
            val updatedNumber = currentState.number2 + number
            _state.value = currentState.copy(
                number2 = updatedNumber,
                displayText = updatedNumber,
                errorMessage = null
            )
        }
    }

    private fun enterDecimal() {
        val currentState = _state.value
        if (currentState.operation == null) {
            if (!currentState.number1.contains(".")) {
                val updatedNumber = if (currentState.number1.isEmpty()) "0." else currentState.number1 + "."
                _state.value = currentState.copy(
                    number1 = updatedNumber,
                    displayText = updatedNumber,
                    errorMessage = null
                )
            }
        } else {
            if (!currentState.number2.contains(".")) {
                val updatedNumber = if (currentState.number2.isEmpty()) "0." else currentState.number2 + "."
                _state.value = currentState.copy(
                    number2 = updatedNumber,
                    displayText = updatedNumber,
                    errorMessage = null
                )
            }
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        val currentState = _state.value
        if (currentState.number1.isNotBlank()) {
            if (currentState.number2.isNotBlank()) {
                performCalculation()
                val calculatedState = _state.value
                if (calculatedState.errorMessage == null) {
                    _state.value = calculatedState.copy(operation = operation)
                }
            } else {
                _state.value = currentState.copy(
                    operation = operation,
                    errorMessage = null
                )
            }
        }
    }

    private fun performCalculation() {
        val currentState = _state.value
        val num1 = currentState.number1.toDoubleOrNull()
        val num2 = currentState.number2.toDoubleOrNull()

        if (num1 != null && num2 != null && currentState.operation != null) {
            if (currentState.operation == CalculatorOperation.Division && num2 == 0.0) {
                _state.value = currentState.copy(
                    displayText = "Cannot divide by zero",
                    errorMessage = "Cannot divide by zero",
                    number1 = "",
                    number2 = "",
                    operation = null
                )
                return
            }

            val result = when (currentState.operation) {
                CalculatorOperation.Addition -> num1 + num2
                CalculatorOperation.Subtraction -> num1 - num2
                CalculatorOperation.Multiplication -> num1 * num2
                CalculatorOperation.Division -> num1 / num2
            }

            val formattedResult = formatResult(result)
            _state.value = currentState.copy(
                number1 = formattedResult,
                number2 = "",
                operation = null,
                displayText = formattedResult,
                errorMessage = null
            )
        }
    }

    private fun performDelete() {
        val currentState = _state.value
        when {
            currentState.number2.isNotEmpty() -> {
                val updatedNumber2 = currentState.number2.dropLast(1)
                _state.value = currentState.copy(
                    number2 = updatedNumber2,
                    displayText = if (updatedNumber2.isEmpty()) "0" else updatedNumber2
                )
            }
            currentState.operation != null -> {
                _state.value = currentState.copy(
                    operation = null,
                    displayText = if (currentState.number1.isEmpty()) "0" else currentState.number1
                )
            }
            currentState.number1.isNotEmpty() -> {
                val updatedNumber1 = currentState.number1.dropLast(1)
                _state.value = currentState.copy(
                    number1 = updatedNumber1,
                    displayText = if (updatedNumber1.isEmpty()) "0" else updatedNumber1
                )
            }
        }
    }

    private fun performClear() {
        _state.value = CalculatorState()
    }

    private fun performToggleSign() {
        val currentState = _state.value
        if (currentState.operation == null && currentState.number1.isNotEmpty()) {
            val updated = if (currentState.number1.startsWith("-")) {
                currentState.number1.substring(1)
            } else {
                "-${currentState.number1}"
            }
            _state.value = currentState.copy(number1 = updated, displayText = updated)
        } else if (currentState.operation != null && currentState.number2.isNotEmpty()) {
            val updated = if (currentState.number2.startsWith("-")) {
                currentState.number2.substring(1)
            } else {
                "-${currentState.number2}"
            }
            _state.value = currentState.copy(number2 = updated, displayText = updated)
        }
    }

    private fun performPercentage() {
        val currentState = _state.value
        if (currentState.operation == null && currentState.number1.isNotEmpty()) {
            val value = currentState.number1.toDoubleOrNull() ?: return
            val formatted = formatResult(value / 100.0)
            _state.value = currentState.copy(number1 = formatted, displayText = formatted)
        } else if (currentState.operation != null && currentState.number2.isNotEmpty()) {
            val value = currentState.number2.toDoubleOrNull() ?: return
            val formatted = formatResult(value / 100.0)
            _state.value = currentState.copy(number2 = formatted, displayText = formatted)
        }
    }

    private fun formatResult(value: Double): String {
        if (value.isNaN() || value.isInfinite()) return "Error"
        return BigDecimal(value)
            .setScale(8, RoundingMode.HALF_UP)
            .stripTrailingZeros()
            .toPlainString()
    }
}
