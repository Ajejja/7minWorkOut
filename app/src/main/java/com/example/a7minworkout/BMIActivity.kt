package com.example.a7minworkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.Toast
import com.example.a7minworkout.databinding.ActivityBmiBinding
import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity : AppCompatActivity() {
    companion object{
        private const val METRIC_UNITS_VIEW="METRIC_UNIT_VIEW"
        private const val US_UNITS_VIEW="US_UNIT_VIEW"
    }

    private var binding: ActivityBmiBinding?=null
    private var currentVisibelView:String= METRIC_UNITS_VIEW
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbarBmiActivity)
        if(supportActionBar!=null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title="Calculate BMI"
        }

        binding?.toolbarBmiActivity?.setNavigationOnClickListener {
            onBackPressed()
        }
        makeVisibleMetricView()
        binding?.RadioGroupUnits?.setOnCheckedChangeListener { _, checkedId:Int ->
            if(checkedId==R.id.rbMetricUnits){
                makeVisibleMetricView()
            }else{
                makeVisibleUsView()
            }
        }
        binding?.flBMIResult?.setOnClickListener{
            calculateUsUnits()
            if(validateMetricUnit()){
                val heightValue:Float=binding?.etMetricUnitHeight?.text.toString().toFloat()/100
                val weightValue:Float=binding?.etMetricUnitWeight?.text.toString().toFloat()
                val bmi = weightValue/(heightValue*heightValue)
                displayBMIResult(bmi)

            }

        }
    }
    private fun makeVisibleMetricView(){
        currentVisibelView= METRIC_UNITS_VIEW
        binding?.tilMetricUnitWeight?.visibility=View.VISIBLE
        binding?.tilMetricUnitHeight?.visibility=View.VISIBLE
        binding?.tilMetricUsUnitHeightFeet?.visibility=View.GONE
        binding?.tilMetricUsUnitHeightInch?.visibility=View.GONE
        binding?.tilMetricUsUnitWeight?.visibility=View.GONE
        binding?.etMetricUnitHeight?.text!!.clear()
        binding?.etMetricUnitWeight?.text!!.clear()
        binding?.llDipplayBMResult?.visibility=View.INVISIBLE


    }
    private fun makeVisibleUsView(){
        currentVisibelView= US_UNITS_VIEW
        binding?.tilMetricUnitWeight?.visibility=View.INVISIBLE
        binding?.tilMetricUnitHeight?.visibility=View.INVISIBLE
        binding?.tilMetricUsUnitHeightFeet?.visibility=View.VISIBLE
        binding?.tilMetricUsUnitHeightInch?.visibility=View.VISIBLE
        binding?.tilMetricUsUnitWeight?.visibility=View.VISIBLE
        binding?.etUsMetricUnitHeightFeet?.text!!.clear()
        binding?.etUsMetricUnitHeightInch?.text!!.clear()
        binding?.etMetricUnitWeight?.text!!.clear()
        binding?.llDipplayBMResult?.visibility=View.INVISIBLE
    }
    private fun displayBMIResult(bmi:Float){
        val bmiLable:String
        val showBmiComment:String
        binding?.llDipplayBMResult?.visibility=View.VISIBLE
        if(bmi.compareTo(15f)<=0){
            bmiLable="Very severely underweight"
            showBmiComment="Oops! You really need to take better care of yourself ! eat well!"
        }
        else if(bmi.compareTo(15f)>0&& bmi.compareTo(16f)<0){
            bmiLable=" severely underweight"
            showBmiComment="Oops! You really need to take better care of yourself ! eat well!"
        }else if(bmi.compareTo(16f)>0&& bmi.compareTo(18.5f)<0){
            bmiLable=" underweight"
            showBmiComment="Oops! You really need to take better care of yourself ! eat well!"
        }
        else if(bmi.compareTo(18.5f)>0 && bmi.compareTo(25f)<0){
            bmiLable=" Normal"
            showBmiComment="Congratulations you are in good shape"
        }else if(bmi.compareTo(25f)>0 && bmi.compareTo(30f)<0){
            bmiLable=" overweight"
            showBmiComment="Oops! You really need to take better care of yourself !Do workout"
        }else if(bmi.compareTo(30f)>0 && bmi.compareTo(35f)<0){
            bmiLable=" obese class|(moderately obese)"
            showBmiComment="Oops! You really need to take better care of yourself !Do workout"
        }else if(bmi.compareTo(35f)>0 && bmi.compareTo(40f)<0){
            bmiLable=" obese class||(Severely obese)"
            showBmiComment="OMG!! Tou are in a very dangerous condition! Act now"
        }else{
            bmiLable=" obese class|||(Very Severely obese)"
            showBmiComment="OMG!! Tou are in a very dangerous condition! Act now"
        }
        val showBmiValue= BigDecimal(bmi.toDouble()).setScale(2,RoundingMode.HALF_EVEN).toString()
        binding?.llDipplayBMResult?.visibility=View.VISIBLE
        binding?.showBmiValue?.text=showBmiValue
        binding?.showBmiType?.text=bmiLable
        binding?.showBmiComment?.text=showBmiComment



    }
    private fun calculateUsUnits(){
        if(currentVisibelView== METRIC_UNITS_VIEW) {

            if (validateMetricUnit()) {
                val heightValue: Float =
                    binding?.etMetricUnitHeight?.text.toString().toFloat() / 100
                val weightValue: Float = binding?.etMetricUnitWeight?.text.toString().toFloat()
                val bmi = weightValue / (heightValue * heightValue)
                displayBMIResult(bmi)

            } else {
                Toast.makeText(this@BMIActivity, "Please enter valid values.", Toast.LENGTH_SHORT)
                    .show()
            }

        }else if(validateUsUnit()){
            val usUnitHeighValueFeet:String=
                binding?.etUsMetricUnitHeightFeet?.text.toString()
            val usUnitHeighValueInch:String=
            binding?.etUsMetricUnitHeightInch?.text.toString()
            val usUnitWeightValue:Float=binding?.etMetricUsUnitWeight?.text.toString().toFloat()
            val heighValue=usUnitHeighValueInch.toFloat()+usUnitHeighValueFeet.toFloat()*12
            val bmi=703*(usUnitWeightValue/(heighValue*heighValue))
            displayBMIResult(bmi)

        }else {
            Toast.makeText(this@BMIActivity, "Please enter valid values.", Toast.LENGTH_SHORT)
                .show()
        }
    }
    private fun validateMetricUnit():Boolean{
        var isValid=true
        if(binding?.etMetricUnitWeight?.text.toString().isEmpty()){
            isValid=false
        }else if(binding?.etMetricUnitHeight?.text.toString().isEmpty()){
            isValid=false
        }
        return isValid
    }
    private fun validateUsUnit():Boolean{
        var isValid=true
        if(binding?.etMetricUsUnitWeight?.text.toString().isEmpty()){
            isValid=false
        }else if(binding?.etUsMetricUnitHeightFeet?.text.toString().isEmpty()){
            isValid=false
        }else if(binding?.etUsMetricUnitHeightInch?.text.toString().isEmpty()){
            isValid=false
        }
        return isValid
    }
}