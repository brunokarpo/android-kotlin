package com.example.bruno.motivationalapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class QuoteFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quote, container, false)
    }

    fun newInstance(quote: String, author: String): QuoteFragment {
        val fragment = QuoteFragment()
        val bundle = Bundle()
        bundle.putString("quote", quote)
        bundle.putString("author", author)

        fragment.arguments = bundle

        return fragment
    }

}
