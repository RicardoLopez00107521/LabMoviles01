package com.example.laboratorio02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.TextureView
import android.widget.Button
import android.widget.TextView
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var actionResultButton: Button
    private lateinit var WeightEditText:EditText
    private lateinit var HeightEditText:EditText
    private lateinit var resultNumber:TextView
    private lateinit var resulthealth:TextView
    private lateinit var resultinfo:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        change()
    }

    private fun bind() {
        actionResultButton = findViewById(R.id.action_result_button)
        WeightEditText = findViewById(R.id.edit_weight_number)
        HeightEditText = findViewById(R.id.edit_height_number)
        resultNumber = findViewById(R.id.result1)
        resulthealth = findViewById(R.id.result2)
        resultinfo = findViewById(R.id.result3)
    }



    private fun change() {
        actionResultButton.setOnClickListener() {
            val Weight = WeightEditText.text.toString()
            val Height = HeightEditText.text.toString()

            val Resultado = Weight.toFloat()/((Height.toFloat()/100)*(Height.toFloat())/100)

            if (Resultado < 18.5) {
                resultNumber.text = Resultado.toString()
                resulthealth.text = "Underweight"
            }

            if (Resultado < 24.99 && Resultado > 18.5) {
                resultNumber.text = Resultado.toString()
                resulthealth.text = "Healthy"
            }

            if (Resultado < 29.99 && Resultado > 25) {
                resultNumber.text = Resultado.toString()
                resulthealth.text = "Overweight"
            }

            if (Resultado < 30) {
                resultNumber.text = Resultado.toString()
                resulthealth.text = "Obese"
            }
        }
    }
}