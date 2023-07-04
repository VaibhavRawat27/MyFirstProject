package com.vaibhavrawat.myfirstproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast

class CheckboxRadioActivity : AppCompatActivity() {
    var cbIAgree : CheckBox?= null
    var btnSubmit : Button?= null
    var name = ""
    var info = ""
    var phoneNumber = ""
    var marks = ""
    var percentage = ""
    var tvDisplay : TextView ?= null
    //var datePicker : DatePicker?= null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox_radio)
        cbIAgree = findViewById(R.id.cbIAgree)
        btnSubmit = findViewById(R.id.btnSubmit)
       // datePicker = findViewById(R.id.DatePicker)
        //datePicker?.setOnDateChangedListener { view, year, monthOfYear, dayOfMonth ->
          //  datePicker!!.showContextMenu()
        //}
        cbIAgree?.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                //Toast.makeText(this, "Checked", Toast.LENGTH_LONG).show()
                btnSubmit?.setOnClickListener {
                    var intent = Intent(this, MainActivity::class.java)
                    Toast.makeText(this, "Form submitted successfully", Toast.LENGTH_LONG).show()
                    startActivity(intent)
                    finish()
                }
            }else{
                //Toast.makeText(this, "Error! Not checked", Toast.LENGTH_SHORT).show()
                cbIAgree?.error = "Please select above filed."
            }

        }



    }

}


