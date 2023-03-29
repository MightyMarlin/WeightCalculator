package com.example.weightcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputWeightEditTextBox = findViewById<EditText>(R.id.inputWeight);
        val outputWeight = findViewById<TextView>(R.id.weightOutput);
        val plates45TextBox = findViewById<TextView>(R.id.plates45);
        val plates25TextBox = findViewById<TextView>(R.id.plates25);
        val plates10TextBox = findViewById<TextView>(R.id.plates10);
        val plates5TextBox = findViewById<TextView>(R.id.plates5);
        val plates2Point5TextBox = findViewById<TextView>(R.id.plates2Point5);

        inputWeightEditTextBox.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val inputWeight = inputWeightEditTextBox.text.toString().toDouble();
                val weightCalc = (inputWeight - 45) / 2;

                outputWeight.setText(weightCalc.toString());

                val numberOf45s = (weightCalc / 45).toInt();
                plates45TextBox.setText(numberOf45s.toString()  + "   x   45lbs");

                var remainder = weightCalc - (numberOf45s * 45);
                val numberOf25s = (remainder / 25).toInt();
                plates25TextBox.setText(numberOf25s.toString()  + "   x   25lbs");

                remainder -= (numberOf25s * 25);
                val numberOf10s = (remainder / 10).toInt();
                plates10TextBox.setText(numberOf10s.toString() + "   x   10lbs");

                remainder -= (numberOf10s * 10);
                val numberOf5s = (remainder / 5).toInt();
                plates5TextBox.setText(numberOf5s.toString()  + "   x   5lbs  ");

                remainder -= (numberOf5s * 5);
                val numberOf2Point5s = (remainder / 2.5).toInt();
                plates2Point5TextBox.setText(" " + numberOf2Point5s.toString()  + "   x   2.5lbs");

                true
            } else {
                false
            }
        }



    }
}