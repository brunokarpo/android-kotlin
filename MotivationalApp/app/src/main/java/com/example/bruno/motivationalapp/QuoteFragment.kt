package com.example.bruno.motivationalapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.bruno.motivationalapp.model.Quote

class QuoteFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_quote, container, false)

        var quote = arguments!!.getString("quote")
        var author = arguments!!.getString("author")

        var quoteText = view.findViewById<TextView>(R.id.quote_text_id)
        var authorText = view.findViewById<TextView>(R.id.author_text_id)

        quoteText.text = quote
        authorText.text = author

        return view
    }

    companion object {
        fun newInstance(quote: Quote): QuoteFragment {
            val fragment = QuoteFragment()
            val bundle = Bundle()
            bundle.putString("quote", quote.quote)
            bundle.putString("author", quote.author)

            fragment.arguments = bundle

            return fragment
        }
    }

}
