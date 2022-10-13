package com.example.lab2task4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

 
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun displayBtn(v: View){
        val textv : TextView = findViewById(R.id.te1)

        val btn : Button = v as Button
        textv.text = textv.text.toString() + btn.text

    }
    fun eval(v: View){
        val textv : TextView = findViewById(R.id.te1)
        var exp: String = textv.text.toString();
        var num: String = ""
        var symbol: Char = '+'
        var result: Int = 0
        for(i in exp) {
            if(i in '0'..'9')
                num += i
            else
            {
                if(symbol == '+')
                    result += Integer.parseInt(num)
                else if(symbol == '-')
                    result -= Integer.parseInt(num)
                else if(symbol == '*')
                    result *= Integer.parseInt(num)
                else if(symbol == '/')
                    result /= Integer.parseInt(num)

                num=""
                symbol = i
            }
        }

        //To calculate the divide by 4 ( result/4 ) in this case
        if(symbol == '+')
            result += Integer.parseInt(num)
        else if(symbol == '-')
            result -= Integer.parseInt(num)
        else if(symbol == '*')
            result *= Integer.parseInt(num)
        else if(symbol == '/')
            result /= Integer.parseInt(num)

        textv.text = ""+result
    }

    fun clear(v: View){
        val textv : TextView = findViewById(R.id.te1)
        textv.text = ""
    }
}