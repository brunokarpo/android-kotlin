package com.example.bruno.animalbio

import android.view.View
import android.widget.Toast

class ImageAnimalListener(val animal: AnimalDetails): View.OnClickListener {

    override fun onClick(v: View?) {
        Toast.makeText(v!!.context, v!!.context.getText(animal.idName), Toast.LENGTH_SHORT).show()
    }
}