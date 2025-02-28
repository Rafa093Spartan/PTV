package com.example.puntodeventaia

import android.content.Context
import android.widget.TextView

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class TotalView(context: Context) : ConstraintLayout(context) {

    init {
        // Configurar el ConstraintLayout
        layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT
        )
        setPadding(16, 16, 16, 16) // Añadir padding

        // Crear un TextView para mostrar el texto
        val totalTextView = TextView(context).apply {
            id = generateViewId() // Asignar un ID único
            text = "Totals: 8AX9X4.XX"
            textSize = 24f // Tamaño del texto
            layoutParams = LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
            )
        }

        // Añadir el TextView al ConstraintLayout
        addView(totalTextView)

        // Configurar las restricciones para centrar el TextView
        val constraintSet = ConstraintSet()
        constraintSet.clone(this)
        constraintSet.centerHorizontally(totalTextView.id, ConstraintSet.PARENT_ID)
        constraintSet.centerVertically(totalTextView.id, ConstraintSet.PARENT_ID)
        constraintSet.applyTo(this)
    }
}