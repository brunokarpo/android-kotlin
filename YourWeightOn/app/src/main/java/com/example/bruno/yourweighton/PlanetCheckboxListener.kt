package com.example.bruno.yourweighton

import android.app.Activity
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

private fun Double.format(digits: Int) = String.format("%.${digits}f", this)

class PlanetCheckboxListener(val planet: Planets, val activity: Activity): View.OnClickListener {

    override fun onClick(v: View?) {
        v as CheckBox
        var isChecked: Boolean = v.isChecked
        var weightStr: String = activity.weight_edit_text_id.text.toString()
        var message: String?

        if (weightStr.isEmpty()) {
            Toast.makeText(activity.applicationContext, R.string.type_your_weight_text, Toast.LENGTH_SHORT).show()
            return
        }

        if (isChecked) {
            var weight = activity.weight_edit_text_id.text.toString().toDouble()
            var result = planet.calculateWeight(weight).format(2)

            message = "Your weight on ${activity.resources.getString(planet.planetName)} is $result"
        } else {
            message = ""
        }

        activity.result_text_view_id.text = message;
    }

}