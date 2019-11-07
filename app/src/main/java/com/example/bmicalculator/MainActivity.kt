package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener{
            calculateBMI()
        }
    }

    private fun calculateBMI()
    {
        //TODO : calculate BMI and show all output
        if(editTextHeight.text.isEmpty())
        {
            editTextHeight.setError(getString(R.string.error_input))
            return
        }
        if(editTextWeight.text.isEmpty())
        {
            editTextWeight.setError(getString(R.string.error_input))
            return
        }
        val weight : Float = editTextWeight.text.toString().toFloat()
        val height : Float = editTextHeight.text.toString().toFloat()

        val bmi = weight / height.pow(2)

        textViewBMI.text = String.format("%s %.2f", getString(R.string.bmi) , bmi)
        if(bmi<18.5)
        {
            imageViewProfile.setImageResource(R.drawable.under)
            textViewStatus.text = String.format("%s %s", getString(R.string.status) , getString(R.string.underweight))
        }
        else if(18.5<bmi && bmi>24.9)
        {
            imageViewProfile.setImageResource(R.drawable.normal)
            textViewStatus.text = String.format("%s %s", getString(R.string.status) , getString(R.string.normal))
        }
        else if(bmi>25.0)
        {
            imageViewProfile.setImageResource(R.drawable.over)
            textViewStatus.text = String.format("%s %s", getString(R.string.status) , getString(R.string.overweight))
        }

    }

    fun resetInput(view: View)
    {
        //TODO clear all input and output
        editTextWeight.setText("")
        editTextHeight.setText("")
        textViewBMI.text = getString(R.string.bmi)
        textViewStatus.text = getString(R.string.status)
    }
}
