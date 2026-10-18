package com.raye.codeorbit_calculator_app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.raye.codeorbit_calculator_app.model.CalculatorAction
import com.raye.codeorbit_calculator_app.model.CalculatorOperation
import com.raye.codeorbit_calculator_app.model.CalculatorState
import com.raye.codeorbit_calculator_app.ui.components.CalculatorButton
import com.raye.codeorbit_calculator_app.ui.components.CalculatorDisplay

@Composable
fun CalculatorScreen(
    state: CalculatorState,
    onAction: (CalculatorAction) -> Unit,
    modifier: Modifier = Modifier
) {
    val actionColor = MaterialTheme.colorScheme.secondaryContainer
    val actionTextColor = MaterialTheme.colorScheme.onSecondaryContainer

    val operatorColor = MaterialTheme.colorScheme.primaryContainer
    val operatorTextColor = MaterialTheme.colorScheme.onPrimaryContainer

    val equalsColor = MaterialTheme.colorScheme.primary
    val equalsTextColor = MaterialTheme.colorScheme.onPrimary

    val numberColor = MaterialTheme.colorScheme.surfaceContainerHigh
    val numberTextColor = MaterialTheme.colorScheme.onSurface

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        CalculatorDisplay(
            state = state,
            modifier = Modifier.weight(1f)
        )

        // Row 1: AC, ±, %, ÷
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CalculatorButton(
                symbol = "AC",
                modifier = Modifier.weight(1f).aspectRatio(1f),
                color = actionColor,
                textColor = actionTextColor,
                onClick = { onAction(CalculatorAction.Clear) }
            )
            CalculatorButton(
                symbol = "±",
                modifier = Modifier.weight(1f).aspectRatio(1f),
                color = actionColor,
                textColor = actionTextColor,
                onClick = { onAction(CalculatorAction.ToggleSign) }
            )
            CalculatorButton(
                symbol = "%",
                modifier = Modifier.weight(1f).aspectRatio(1f),
                color = actionColor,
                textColor = actionTextColor,
                onClick = { onAction(CalculatorAction.Percent) }
            )
            CalculatorButton(
                symbol = "÷",
                modifier = Modifier.weight(1f).aspectRatio(1f),
                color = operatorColor,
                textColor = operatorTextColor,
                onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Division)) }
            )
        }

        // Row 2: 7, 8, 9, ×
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CalculatorButton(
                symbol = "7",
                modifier = Modifier.weight(1f).aspectRatio(1f),
                color = numberColor,
                textColor = numberTextColor,
                onClick = { onAction(CalculatorAction.Number(7)) }
            )
            CalculatorButton(
                symbol = "8",
                modifier = Modifier.weight(1f).aspectRatio(1f),
                color = numberColor,
                textColor = numberTextColor,
                onClick = { onAction(CalculatorAction.Number(8)) }
            )
            CalculatorButton(
                symbol = "9",
                modifier = Modifier.weight(1f).aspectRatio(1f),
                color = numberColor,
                textColor = numberTextColor,
                onClick = { onAction(CalculatorAction.Number(9)) }
            )
            CalculatorButton(
                symbol = "×",
                modifier = Modifier.weight(1f).aspectRatio(1f),
                color = operatorColor,
                textColor = operatorTextColor,
                onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Multiplication)) }
            )
        }

        // Row 3: 4, 5, 6, -
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CalculatorButton(
                symbol = "4",
                modifier = Modifier.weight(1f).aspectRatio(1f),
                color = numberColor,
                textColor = numberTextColor,
                onClick = { onAction(CalculatorAction.Number(4)) }
            )
            CalculatorButton(
                symbol = "5",
                modifier = Modifier.weight(1f).aspectRatio(1f),
                color = numberColor,
                textColor = numberTextColor,
                onClick = { onAction(CalculatorAction.Number(5)) }
            )
            CalculatorButton(
                symbol = "6",
                modifier = Modifier.weight(1f).aspectRatio(1f),
                color = numberColor,
                textColor = numberTextColor,
                onClick = { onAction(CalculatorAction.Number(6)) }
            )
            CalculatorButton(
                symbol = "-",
                modifier = Modifier.weight(1f).aspectRatio(1f),
                color = operatorColor,
                textColor = operatorTextColor,
                onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Subtraction)) }
            )
        }

        // Row 4: 1, 2, 3, +
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CalculatorButton(
                symbol = "1",
                modifier = Modifier.weight(1f).aspectRatio(1f),
                color = numberColor,
                textColor = numberTextColor,
                onClick = { onAction(CalculatorAction.Number(1)) }
            )
            CalculatorButton(
                symbol = "2",
                modifier = Modifier.weight(1f).aspectRatio(1f),
                color = numberColor,
                textColor = numberTextColor,
                onClick = { onAction(CalculatorAction.Number(2)) }
            )
            CalculatorButton(
                symbol = "3",
                modifier = Modifier.weight(1f).aspectRatio(1f),
                color = numberColor,
                textColor = numberTextColor,
                onClick = { onAction(CalculatorAction.Number(3)) }
            )
            CalculatorButton(
                symbol = "+",
                modifier = Modifier.weight(1f).aspectRatio(1f),
                color = operatorColor,
                textColor = operatorTextColor,
                onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Addition)) }
            )
        }

        // Row 5: 0, ., ⌫, =
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CalculatorButton(
                symbol = "0",
                modifier = Modifier.weight(1f).aspectRatio(1f),
                color = numberColor,
                textColor = numberTextColor,
                onClick = { onAction(CalculatorAction.Number(0)) }
            )
            CalculatorButton(
                symbol = ".",
                modifier = Modifier.weight(1f).aspectRatio(1f),
                color = numberColor,
                textColor = numberTextColor,
                onClick = { onAction(CalculatorAction.Decimal) }
            )
            CalculatorButton(
                symbol = "⌫",
                modifier = Modifier.weight(1f).aspectRatio(1f),
                color = numberColor,
                textColor = numberTextColor,
                onClick = { onAction(CalculatorAction.Delete) }
            )
            CalculatorButton(
                symbol = "=",
                modifier = Modifier.weight(1f).aspectRatio(1f),
                color = equalsColor,
                textColor = equalsTextColor,
                onClick = { onAction(CalculatorAction.Calculate) }
            )
        }
    }
}
