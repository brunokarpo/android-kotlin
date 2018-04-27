package com.example.bruno.reciclerlistviewsapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.bruno.reciclerlistviewsapp.data.PersonListAdapter
import com.example.bruno.reciclerlistviewsapp.model.Person
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var adapter: PersonListAdapter? = null
    private var personList: ArrayList<Person>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        personList = arrayListOf()
        layoutManager = LinearLayoutManager(this)
        adapter = PersonListAdapter(personList!!, this)


        recycler_view_id.layoutManager = layoutManager
        recycler_view_id.adapter = adapter

        for(i in 0..16) {
            val person = Person("James $i", 20 + i, R.mipmap.ic_launcher)
            personList!!.add(person)
        }

        adapter!!.notifyDataSetChanged()

    }
}
