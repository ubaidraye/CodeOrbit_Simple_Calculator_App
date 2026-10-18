package com.raye.codeorbit_calculator_app

import com.raye.codeorbit_calculator_app.model.CalculatorAction
import com.raye.codeorbit_calculator_app.model.CalculatorOperation
import com.raye.codeorbit_calculator_app.ui.CalculatorViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CalculatorViewModelTest {

    private lateinit var viewModel: CalculatorViewModel

    @Before
    fun setUp() {
        viewModel = CalculatorViewModel()
    }

    @Test
    fun testAddition() {
        viewModel.onAction(CalculatorAction.Number(5))
        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Addition))
        viewModel.onAction(CalculatorAction.Number(3))
        viewModel.onAction(CalculatorAction.Calculate)

        assertEquals("8", viewModel.state.value.displayText)
    }

    @Test
    fun testSubtraction() {
        viewModel.onAction(CalculatorAction.Number(1))
        viewModel.onAction(CalculatorAction.Number(0))
        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Subtraction))
        viewModel.onAction(CalculatorAction.Number(4))
        viewModel.onAction(CalculatorAction.Calculate)

        assertEquals("6", viewModel.state.value.displayText)
    }

    @Test
    fun testMultiplication() {
        viewModel.onAction(CalculatorAction.Number(6))
        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Multiplication))
        viewModel.onAction(CalculatorAction.Number(7))
        viewModel.onAction(CalculatorAction.Calculate)

        assertEquals("42", viewModel.state.value.displayText)
    }

    @Test
    fun testDivision() {
        viewModel.onAction(CalculatorAction.Number(1))
        viewModel.onAction(CalculatorAction.Number(5))
        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Division))
        viewModel.onAction(CalculatorAction.Number(3))
        viewModel.onAction(CalculatorAction.Calculate)

        assertEquals("5", viewModel.state.value.displayText)
    }

    @Test
    fun testDivisionByZero() {
        viewModel.onAction(CalculatorAction.Number(9))
        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Division))
        viewModel.onAction(CalculatorAction.Number(0))
        viewModel.onAction(CalculatorAction.Calculate)

        assertEquals("Cannot divide by zero", viewModel.state.value.displayText)
        assertEquals("Cannot divide by zero", viewModel.state.value.errorMessage)
    }

    @Test
    fun testDecimalOperations() {
        viewModel.onAction(CalculatorAction.Number(2))
        viewModel.onAction(CalculatorAction.Decimal)
        viewModel.onAction(CalculatorAction.Number(5))
        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Addition))
        viewModel.onAction(CalculatorAction.Number(3))
        viewModel.onAction(CalculatorAction.Decimal)
        viewModel.onAction(CalculatorAction.Number(5))
        viewModel.onAction(CalculatorAction.Calculate)

        assertEquals("6", viewModel.state.value.displayText)
    }

    @Test
    fun testClear() {
        viewModel.onAction(CalculatorAction.Number(5))
        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Addition))
        viewModel.onAction(CalculatorAction.Clear)

        assertEquals("0", viewModel.state.value.displayText)
        assertEquals("", viewModel.state.value.number1)
    }

    @Test
    fun testDelete() {
        viewModel.onAction(CalculatorAction.Number(1))
        viewModel.onAction(CalculatorAction.Number(2))
        viewModel.onAction(CalculatorAction.Delete)

        assertEquals("1", viewModel.state.value.displayText)
    }
}
