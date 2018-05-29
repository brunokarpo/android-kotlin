package com.example.bruno.motivationalapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.bruno.motivationalapp.controller.QuoteData
import com.example.bruno.motivationalapp.controller.QuoteListAsyncResponse
import com.example.bruno.motivationalapp.controller.QuoteViewPagerAdapter
import com.example.bruno.motivationalapp.model.Quote
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var quoteViewPagerAdapter: QuoteViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quoteViewPagerAdapter = QuoteViewPagerAdapter(supportFragmentManager, getFragments())

        main_view_pager_id.adapter = quoteViewPagerAdapter

    }

    fun getFragments(): ArrayList<QuoteFragment> {
        val fragmentList = arrayListOf<QuoteFragment>()

        QuoteData().getQuotes(object : QuoteListAsyncResponse {
            override fun processFinished(quotes: ArrayList<Quote>) {
                for (i in 0 until quotes.size) {
                    val quoteFragment = QuoteFragment.newInstance(quotes[i])

                    fragmentList.add(quoteFragment)
                }
                quoteViewPagerAdapter.notifyDataSetChanged()
            }
        })
        return fragmentList
    }
}
