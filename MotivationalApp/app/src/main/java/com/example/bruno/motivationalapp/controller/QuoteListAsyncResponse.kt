package com.example.bruno.motivationalapp.controller

import com.example.bruno.motivationalapp.model.Quote

interface QuoteListAsyncResponse {
    fun processFinished(quotes: ArrayList<Quote>)
}
