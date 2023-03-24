package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    //------Step 1-------
    lateinit var binding: ActivityMainBinding //Initialize activity main binding by using lateinit type


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //-----Step 2 now initialize views under onCreate------
        binding = ActivityMainBinding.inflate(layoutInflater) //binding object made

        //-------Step 3---------In set content view use binding type
        setContentView(binding.root)


       //--------Step 4 ------bind the button:
        binding.calculate.setOnClickListener { calculateTip() }

    }
    //Step 5 ----- make the function
    private fun calculateTip()
    {

        val cost : Double = binding.billAmount.text.toString().toDouble()
        val tipPercentage : Double = binding.billAmount.text.toString().toDouble()
        var total :Double = ((100 + tipPercentage) / 100 ) * cost
        total = ceil(total)
        //bind totalTip textview to text
        val currencyTip : String = NumberFormat.getCurrencyInstance().format(total)
        binding.totalTip.text = getString(R.string.tip_amount2, currencyTip)
    }





}