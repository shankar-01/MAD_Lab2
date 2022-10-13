package com.example.lab2task3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var quantity: Int  = 0
    var isCreame: Boolean = false;
    var isChocolate: Boolean = false
    val summaryTemplate = "Add whipped cream? <cream> \nAdd chocolate? <chocolate> \nQuantity: <quantity> \n\n Price: <price> \nTHANK YOU!";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun onClick_CheckBox(v: View){
        val c1 : CheckBox = findViewById(R.id.checkBox)
        isCreame = c1.isChecked
        val c2 : CheckBox = findViewById(R.id.checkBox2)
        isChocolate = c2.isChecked
    }
    fun decrease(v:View){
        if(quantity>0)
            quantity--
        updateQuantity()
    }
    fun increase(v:View){
        quantity++
        updateQuantity()
    }
    fun updateQuantity(){
        val textView: TextView = findViewById(R.id.quantity)
        textView.text = ""+quantity;
    }
    fun placeOrder(v:View){
        var summary : String = summaryTemplate
        summary = summary.replace("<cream>", if(isCreame)"yes" else "no");
        summary = summary.replace("<chocolate>", if(isChocolate)"yes" else "no");
        summary = summary.replace("<quantity>", ""+quantity);
        summary = summary.replace("<price>", "$"+calculatePrice());
        val textView : TextView = findViewById(R.id.summary)
        textView.text = summary;
    }
    fun calculatePrice():Double{
        var price: Double = quantity * 4.0
        if(isCreame)
            price += 0.5*quantity
        if(isChocolate)
            price += 1;
        return price
    }
}