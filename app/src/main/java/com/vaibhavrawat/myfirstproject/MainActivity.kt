package com.vaibhavrawat.myfirstproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.accessibility.AccessibilityEventCompat.setAction
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    var btnNext: Button ?= null
    var btnValidate : Button?= null
    var etName : EditText?= null
    var etInfo : EditText?= null
    var etNumber : EditText?= null
    var etMarks : EditText?= null
    var etPercentage : EditText?= null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnNext = findViewById(R.id.btnNext)
        btnValidate = findViewById(R.id.btnValidate)
        etName = findViewById(R.id.etName)
        etInfo = findViewById(R.id.etInfo)
        etNumber = findViewById(R.id.etNumber)
        etMarks = findViewById(R.id.etMarks)
        etPercentage = findViewById(R.id.etPercentage)

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
                var intent = Intent(this, Testing::class.java)
                intent.putExtra("name", etName?.text.toString())
                intent.putExtra("Info",etInfo?.text.toString())
                intent.putExtra("phoneNumber",etNumber?.text.toString())
                intent.putExtra("marks", etMarks?.text.toString())
                intent.putExtra("percentage", etPercentage?.text.toString())
                startActivity(intent)
                finish()
            }
        }
        btnNext?.setOnClickListener {
            btnNext?.let {
                Snackbar.make(it, "UNDO/DELETE THE VALUES" , Snackbar.LENGTH_INDEFINITE)
                    .setAction("Clear"){
                        Toast.makeText(this, "DATA CLEARED SUCCESSFULLY", Toast.LENGTH_SHORT).show()
                        //var intent = Intent(this, ::class.java)
                        //startActivity(intent)
                        etName?.setText("")
                       etInfo?.setText("")
                       etMarks?.setText("")
                        etPercentage?.setText("")
                        etNumber?.setText("")

                    }
                   // .setAnchorView(btnNext)
                    .show()

            }
           // var intent = Intent(this, CheckboxRadioActivity::class.java)
            //           // startActivity(intent)
            //        // finish()
        }
    }

}


