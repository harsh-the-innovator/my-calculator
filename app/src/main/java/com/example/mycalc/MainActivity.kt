package com.example.mycalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

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
            R.id.btnAdd -> onAddBtnPress()
            R.id.btnSubtract -> onSubtractBtnPress()
            R.id.btnMultiply -> onMultiplyBtnPress()
            R.id.btnDivide -> onDivideBtnPress()
            R.id.btnClear -> onTextClear()
            R.id.btnEqual -> onEqualBtnPress()
            R.id.btnDot -> onDecimalBtnPress()
            else -> onDigit(view)
        }
    }

    private fun onAddBtnPress() {
        Toast.makeText(this,"Add",Toast.LENGTH_SHORT).show()
    }

    private fun onSubtractBtnPress() {
        Toast.makeText(this,"Subtract",Toast.LENGTH_SHORT).show()
    }

    private fun onMultiplyBtnPress() {
        Toast.makeText(this,"Multiply",Toast.LENGTH_SHORT).show()
    }

    private fun onDivideBtnPress() {
        Toast.makeText(this,"Divide",Toast.LENGTH_SHORT).show()
    }


    private fun onDigit(view: View){
        tvInput?.append((view as Button).text)
        lastNumeric = true
        lastDot = false
    }

    private fun onTextClear(){
        tvInput?.text = ""
    }

    private fun onEqualBtnPress() {
        Toast.makeText(this,"Equal",Toast.LENGTH_SHORT).show()
    }


    private fun onDecimalBtnPress() {
        if(lastNumeric && !lastDot){
            tvInput?.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

}