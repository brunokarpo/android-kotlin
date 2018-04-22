package com.example.bruno.yourweighton

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

private fun Double.format(digits: Int) = String.format("%.${digits}f", this)

class MainActivity : AppCompatActivity() {

    private val marsGravity: Float = 0.38f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var weight = weight_edit_text_id.text

        show_weight_button_id.setOnClickListener {
            var result = calculateWeight(weight.toString().toDouble())

            result_text_view_id.text = "You weight is ${result.format(2)} on Mars"
        }
    }

    private fun calculateWeight(userWeight: Double): Double {
        return userWeight * marsGravity
    }

}
