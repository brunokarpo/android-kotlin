package com.example.bruno.recyclerviewappexercise

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.bruno.recyclerviewappexercise.contracts.NewCoinContract
import com.example.bruno.recyclerviewappexercise.presenter.NewCoinPresenterImpl
import kotlinx.android.synthetic.main.activity_coin.*

class CoinActivity : AppCompatActivity(), NewCoinContract.NewCoinView {

    private var newCoinPresenter = NewCoinPresenterImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin)

        add_coin_button_id.setOnClickListener {
            var name = coin_name_editText_id.text.toString()
            var value = coin_value_editText_id.text.toString().toDouble()

            newCoinPresenter.addNewCoin(name, value)
        }

    }

    override fun completeActivity() {
        var returnIntent = this.intent
        setResult(Activity.RESULT_OK, returnIntent)
        finish()
    }
}
