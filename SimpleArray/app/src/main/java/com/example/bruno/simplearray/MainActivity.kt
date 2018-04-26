package com.example.bruno.simplearray

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ListViews = requires adapters and datasource

        // datasource: datas
        var namesArray: Array<String> = arrayOf("Jenny", "Paul", "Santos", "Lee", "Riuji", "Jenny", "Paul", "Santos", "Lee", "Riuji"
                                                ,"Jenny", "Paul", "Santos", "Lee", "Riuji", "Jenny", "Paul", "Santos", "Lee", "Riuji")


        // adapter: adapt the datasource
        var namesAdapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, namesArray)

        list_view_id.adapter = namesAdapter

        list_view_id.setOnItemClickListener { parent, view, position, id ->
            var itemName: String = list_view_id.getItemAtPosition(position).toString()
            Toast.makeText(this, "Name: $itemName", Toast.LENGTH_LONG).show()
        }
    }
}
