package com.example.puntodeventaia


import android.content.Context
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class PaymentErrorView(context: Context) : ConstraintLayout(context) {

    init {
        // Configurar el ConstraintLayout
        layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT
        )
        setPadding(32, 32, 32, 32) // Añadir padding

        // Crear un TextView para "CashUP"
        val cashUpTextView = TextView(context).apply {
            id = generateViewId() // Asignar un ID único
            text = "CashUP"
            textSize = 28f // Tamaño del texto
            layoutParams = LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
            )
        }

        // Crear un TextView para "Error en el pago."
        val errorTextView = TextView(context).apply {
            id = generateViewId() // Asignar un ID único
            text = "Error en el pago."
            textSize = 24f // Tamaño del texto
            layoutParams = LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
            )
        }

        // Crear un TextView para "Reintenta o cambia"
        val retryTextView = TextView(context).apply {
            id = generateViewId() // Asignar un ID único
            text = "Rententa o cambia"
            textSize = 20f // Tamaño del texto
            layoutParams = LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
            )
        }

        // Añadir los TextViews al ConstraintLayout
        addView(cashUpTextView)
        addView(errorTextView)
        addView(retryTextView)

        // Configurar las restricciones para organizar los TextViews
        val constraintSet = ConstraintSet()
        constraintSet.clone(this)

        // Posicionar "CashUP" en la parte superior centrada
        constraintSet.centerHorizontally(cashUpTextView.id, ConstraintSet.PARENT_ID)
        constraintSet.connect(cashUpTextView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 32)

        // Posicionar "Error en el pago." debajo de "CashUP"
        constraintSet.centerHorizontally(errorTextView.id, ConstraintSet.PARENT_ID)
        constraintSet.connect(errorTextView.id, ConstraintSet.TOP, cashUpTextView.id, ConstraintSet.BOTTOM, 32)

        // Posicionar "Reintenta o cambia" debajo de "Error en el pago."
        constraintSet.centerHorizontally(retryTextView.id, ConstraintSet.PARENT_ID)
        constraintSet.connect(retryTextView.id, ConstraintSet.TOP, errorTextView.id, ConstraintSet.BOTTOM, 32)

        // Aplicar las restricciones
        constraintSet.applyTo(this)
    }
}