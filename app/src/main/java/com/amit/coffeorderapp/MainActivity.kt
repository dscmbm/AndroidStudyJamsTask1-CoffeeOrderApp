package com.amit.coffeorderapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var plusSign: Button? = null
    var minusSign: Button? = null
    var placeOrder: Button? = null
    var qty: TextView? = null
    var finalMessage: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        plusSign = findViewById<View>(R.id.plus) as Button
        minusSign = findViewById<View>(R.id.minus) as Button
        placeOrder = findViewById<View>(R.id.placeOrder) as Button
        qty = findViewById<View>(R.id.quantity) as TextView
        finalMessage = findViewById<View>(R.id.finalAmt) as TextView
        plusSign!!.setOnClickListener {
            var quantity = Integer.valueOf(qty!!.text.toString())
            quantity++
            qty!!.text = "" + quantity
        }
        minusSign!!.setOnClickListener {
            var quantity = Integer.valueOf(qty!!.text.toString())
            quantity--
            if (quantity < 1) quantity = 1
            qty!!.text = "" + quantity
        }
        placeOrder!!.setOnClickListener {
            val quantity = Integer.valueOf(qty!!.text.toString())
            val amount = 50 * quantity
            finalMessage!!.text = "Your order for $$amount has been placed"
            qty!!.text = "1"
        }
    }
}