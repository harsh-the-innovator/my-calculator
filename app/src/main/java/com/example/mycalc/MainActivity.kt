package com.example.mycalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {

    private var tvInput:TextView? = null
    private var btnZero:Button? = null
    private var btnOne:Button? = null
    private var btnTwo:Button? = null
    private var btnThree:Button? = null
    private var btnFour:Button? = null
    private var btnFive:Button? = null
    private var btnSix:Button?  = null
    private var btnSeven:Button? = null
    private var btnEight:Button? = null
    private var btnNine:Button? = null
    private var btnAdd:Button? = null
    private var btnSubtract:Button? = null
    private var btnMultiply:Button? = null
    private var btnDivide:Button? = null
    private var btnEqual:Button? = null
    private var btnClear:Button? = null
    private var btnDot:Button? = null

    private var lastNumeric:Boolean = false
    private var lastDot:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

        btnZero?.setOnClickListener(myBtnClickListener)
        btnOne?.setOnClickListener(myBtnClickListener)
        btnTwo?.setOnClickListener(myBtnClickListener)
        btnThree?.setOnClickListener(myBtnClickListener)
        btnFour?.setOnClickListener(myBtnClickListener)
        btnFive?.setOnClickListener(myBtnClickListener)
        btnSix?.setOnClickListener(myBtnClickListener)
        btnSeven?.setOnClickListener(myBtnClickListener)
        btnEight?.setOnClickListener(myBtnClickListener)
        btnNine?.setOnClickListener(myBtnClickListener)
        btnAdd?.setOnClickListener(myBtnClickListener)
        btnSubtract?.setOnClickListener(myBtnClickListener)
        btnMultiply?.setOnClickListener(myBtnClickListener)
        btnDivide?.setOnClickListener(myBtnClickListener)
        btnEqual?.setOnClickListener(myBtnClickListener)
        btnClear?.setOnClickListener(myBtnClickListener)
        btnDot?.setOnClickListener(myBtnClickListener)
    }

    private fun initViews(){
        tvInput = findViewById(R.id.tvInput)
        btnZero = findViewById(R.id.btnZero)
        btnOne = findViewById(R.id.btnOne)
        btnTwo = findViewById(R.id.btnTwo)
        btnThree = findViewById(R.id.btnThree)
        btnFour = findViewById(R.id.btnFour)
        btnFive = findViewById(R.id.btnFive)
        btnSix = findViewById(R.id.btnSix)
        btnSeven = findViewById(R.id.btnSeven)
        btnEight = findViewById(R.id.btnEight)
        btnNine = findViewById(R.id.btnNine)
        btnAdd = findViewById(R.id.btnAdd)
        btnSubtract = findViewById(R.id.btnSubtract)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnDivide = findViewById(R.id.btnDivide)
        btnEqual = findViewById(R.id.btnEqual)
        btnClear = findViewById(R.id.btnClear)
        btnDot = findViewById(R.id.btnDot)
    }

    private val myBtnClickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.btnAdd -> onOperator(view)
            R.id.btnSubtract -> onOperator(view)
            R.id.btnMultiply -> onOperator(view)
            R.id.btnDivide -> onOperator(view)
            R.id.btnClear -> onTextClear()
            R.id.btnEqual -> onEqualBtnPress(view)
            R.id.btnDot -> onDecimalBtnPress()
            else -> onDigit(view)
        }
    }

    private fun onDigit(view: View){
        tvInput?.append((view as Button).text)
        lastNumeric = true
        lastDot = false
    }

    private fun onTextClear(){
        tvInput?.text = ""
    }

    private fun onEqualBtnPress(view: View) {
        if(lastNumeric){
            var tvValue = tvInput?.text.toString()
            var prefix = ""
            try {
                if(tvValue.startsWith("-")){
                    prefix = "-"
                    tvValue = tvValue.substring(1)
                }

                if(tvValue.contains("-")){
                    val splitValue = tvValue.split("-")

                    var operandOne = splitValue[0]
                    var operandTwo = splitValue[1]

                    if(prefix.isNotEmpty()){
                        operandOne = prefix + operandOne
                    }
                    val result = operandOne.toDouble() - operandTwo.toDouble()
                    tvInput?.text = removeZeroAfterDecimal(result.toString())
                }else if(tvValue.contains("+")){
                    val splitValue = tvValue.split("+")

                    var operandOne = splitValue[0]
                    var operandTwo = splitValue[1]

                    if(prefix.isNotEmpty()){
                        operandOne = prefix + operandOne
                    }
                    val result = operandOne.toDouble() + operandTwo.toDouble()
                    tvInput?.text = removeZeroAfterDecimal(result.toString())
                }else if(tvValue.contains("*")){
                    val splitValue = tvValue.split("*")

                    var operandOne = splitValue[0]
                    var operandTwo = splitValue[1]

                    if(prefix.isNotEmpty()){
                        operandOne = prefix + operandOne
                    }
                    val result = operandOne.toDouble() * operandTwo.toDouble()
                    tvInput?.text = removeZeroAfterDecimal(result.toString())
                }else if(tvValue.contains("/")){
                    val splitValue = tvValue.split("/")

                    var operandOne = splitValue[0]
                    var operandTwo = splitValue[1]

                    if(prefix.isNotEmpty()){
                        operandOne = prefix + operandOne
                    }

                    val result = operandOne.toDouble() / operandTwo.toDouble()
                    tvInput?.text = removeZeroAfterDecimal(result.toString())
                }
            }catch (e:ArithmeticException){
                e.printStackTrace()
            }
        }
    }

    private fun removeZeroAfterDecimal(result:String):String{
        var value = result
        if(result.contains(".0")){
            value = result.substring(0,result.length-2)
        }

        return value
    }


    private fun onDecimalBtnPress() {
        if(lastNumeric && !lastDot){
            tvInput?.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    private fun onOperator(view: View){
        tvInput?.text?.let {
            if(lastNumeric && !isOperatorAdded(it.toString())){
                tvInput?.append((view as Button).text)
                lastNumeric = false
                lastDot = false
            }
        }
    }

    private fun isOperatorAdded(value:String):Boolean{
        return if(value.startsWith("-")){
            false
        }else{
            value.contains("/") ||
            value.contains("*") ||
            value.contains("+") ||
            value.contains("-")

        }
    }

}