package com.vashu.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var tvinput: TextView? = null;

    var lastNumeric: Boolean = false
    var lastDot: Boolean = false;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tvinput = findViewById(R.id.textView)

    }


    fun onDigit(view: View) {

        tvinput?.append((view as Button).text)

        lastNumeric = true;
        lastDot = false


    }

    fun onClear(view: View) {
        tvinput?.text = ""
    }


    fun onDot(view: View) {

        if (lastNumeric && !lastDot) {
            tvinput?.append(".")
        }
        lastNumeric = false
        lastDot = true


    }

    fun onOperator(view: View) {

        tvinput?.text?.let{

        if(lastNumeric && !isOperatorAdded(it.toString())){
            tvinput?.append((view as Button).text)

            lastDot = false
            lastNumeric = false




        }



    }
    }


    fun onEqual(view: View) {
        if(lastNumeric){
            var tvValue = tvinput?.text.toString()

            var prefix = ""

            try {

                if(tvValue.startsWith("-")){
                    prefix = "-"
                    tvValue = tvValue.substring(1)
                }

                if(tvValue.contains("-")) {


                    var splitValue = tvValue.split("-")

                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (prefix.isNotEmpty()) {
                        one = prefix + one


                    }

                    tvinput?.text = removeZeroAfterDot((one.toDouble() - two.toDouble()).toString())
                } else if(tvValue.contains("+")) {


                    var splitValue = tvValue.split("+")

                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (prefix.isNotEmpty()) {
                        one = prefix + one


                    }

                    tvinput?.text =removeZeroAfterDot( (one.toDouble() + two.toDouble()).toString())
                } else if(tvValue.contains("/")) {


                    var splitValue = tvValue.split("/")

                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (prefix.isNotEmpty()) {
                        one = prefix + one


                    }

                    tvinput?.text = removeZeroAfterDot((one.toDouble() / two.toDouble()).toString())
                } else if(tvValue.contains("*")) {


                    var splitValue = tvValue.split("*")

                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (prefix.isNotEmpty()) {
                        one = prefix + one


                    }

                    tvinput?.text = removeZeroAfterDot((one.toDouble() * two.toDouble()).toString())
                }




            }catch (e: java.lang.ArithmeticException){

                e.printStackTrace()
            }
        }



    }


    private fun removeZeroAfterDot(result: String):String{

        var value = result
        if(result.contains(".0")){

            value = result.substring(0,result.length-2)

        }

        return value


    }





    private fun isOperatorAdded(value: String): Boolean {
        return if (value.startsWith("-")) {
            false
        } else {
            value.contains("/") || value.contains("*") || value.contains("+") || value.contains("-")
        }


    }
}