package com.vaibhavrawat.myfirstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var btnNext: Button?= null
    var btnValidate : Button?= null
    var etName : EditText?= null
    var etInfo : EditText?= null
    var etNumber : EditText?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnNext = findViewById(R.id.btnNext)
        btnValidate = findViewById(R.id.btnValidate)
        etName = findViewById(R.id.etName)
        etInfo = findViewById(R.id.etInfo)
        etNumber = findViewById(R.id.etNumber)

        btnValidate?.setOnClickListener {
            if(etName?.text.isNullOrEmpty()){
                etName?.error = "Please enter your name."
            }else if(etInfo?.text.isNullOrEmpty()){
                etInfo?.error = "Please enter something."
            }else if(etNumber?.text.isNullOrEmpty()){
                etNumber?.error = "Please enter mobile number."
            }else if(etNumber?.text.toString().length<10){
                etNumber?.error = "Please enter a valid mobile number."
            }else {
                Toast.makeText(this, "Validation done successfully", Toast.LENGTH_LONG).show()
                var intent = Intent(this, CheckboxRadioActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        btnNext?.setOnClickListener {
           // var intent = Intent(this, CheckboxRadioActivity::class.java)
           // startActivity(intent)
            finish()
        }
    }

}