package com.example.bruno.yourweighton

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*

private fun Double.format(digits: Int) = String.format("%.${digits}f", this)

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val marsGravity: Float = 0.38f
    private val venusGravity: Float = 0.91f
    private val jupterGravity: Float = 2.34f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var weight = weight_edit_text_id.text

        show_weight_button_id.setOnClickListener {
            var result = calculateWeight(weight.toString().toDouble())

            result_text_view_id.text = "You weight is ${result.format(2)} on Mars"
        }

        mars_checkbox_id.setOnClickListener(this)
        venus_checkbox_id.setOnClickListener(this)
        jupter_checkbox_id.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        view as CheckBox
        var isChecked: Boolean = view.isChecked

        when(view.id) {
            R.id.mars_checkbox_id -> if(isChecked) Log.d("Setup Mars", "Mars")
            R.id.venus_checkbox_id -> if(isChecked) Log.d("Setup Venus", "Venus")
            R.id.jupter_checkbox_id -> if(isChecked) Log.d("Setup Jupter", "Jupter")
        }
    }

    private fun calculateWeight(userWeight: Double): Double {
        return userWeight * marsGravity
    }

}
