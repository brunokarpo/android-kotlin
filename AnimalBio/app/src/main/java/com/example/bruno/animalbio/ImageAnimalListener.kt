package com.example.bruno.animalbio

import android.content.Intent
import android.view.View

class ImageAnimalListener(val animal: AnimalDetails): View.OnClickListener {

    override fun onClick(v: View?) {
        val context = v!!.context
        var detailsIntent = Intent(context, DetailsActivity::class.java)
        detailsIntent.putExtra("idName", animal.idName)
        detailsIntent.putExtra("idDetails", animal.idDetails)
        detailsIntent.putExtra("idImage", animal.idImage)

        context.startActivity(detailsIntent)
    }
}