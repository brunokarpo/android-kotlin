package com.example.bruno.checkboxwidget

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.CheckBox

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onCheckBoxClicked(view: View) {
        view as CheckBox // cast our view as a Checkbox object or type or View
        var isChecked: Boolean = view.isChecked

        when(view.id) {
            R.id.veggies_check_id -> if(isChecked) Log.d("Veggies", "Is Checked") else Log.d("Veggies", "No Checked")
            R.id.meat_check_id -> if(isChecked) Log.d("Meat", "Is Checked") else Log.d("Meat", "No Checked")
            R.id.fruit_check_id -> if(isChecked) Log.d("Fruit", "Is Checked") else Log.d("Fruit", "No Checked")
        }

//        Log.d("Checks", "Checkbox ${view.id} clicked")
    }
}
