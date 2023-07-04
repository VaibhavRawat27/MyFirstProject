package com.vaibhavrawat.myfirstproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast

class Testing : AppCompatActivity() {
    var name = ""
    var info = ""
    var phoneNumber = ""
    var marks = ""
    var percentage = ""
    var tvDisplayName: TextView? = null
    var tvDisplayInfo: TextView? = null
    var tvDisplayPhoneNumber: TextView? = null
    var tvDisplayMarks: TextView? = null
    var tvDisplayPercentage: TextView? = null
    var btnContinue: Button? = null
    var cbIAgree: CheckBox? = null
    var btnBack: Button?= null

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testing)
        tvDisplayName = findViewById(R.id.tvDisplayName)
        tvDisplayInfo = findViewById(R.id.tvDisplayInfo)
        tvDisplayPhoneNumber = findViewById(R.id.tvDisplayPhoneNumber)
        tvDisplayMarks = findViewById(R.id.tvDisplayMarks)
        tvDisplayPercentage = findViewById(R.id.tvDisplayPercentage)
        btnContinue = findViewById(R.id.btnContinue)
        cbIAgree = findViewById(R.id.cbIAgree)
        btnBack = findViewById(R.id.btnBack)
        intent?.let {
            name = it.getStringExtra("name") ?: ""
            info = it.getStringExtra("Info") ?: ""
            phoneNumber = it.getStringExtra("phoneNumber") ?: ""
            marks = it.getStringExtra("marks") ?: ""
            percentage = it.getStringExtra("percentage") ?: ""
          //  System.out.println("Name $name College $info Phone Number $phoneNumber Marks $marks Percentage $percentage")
        }
        tvDisplayName?.setText("Name : $name")
        tvDisplayInfo?.setText("Information : $info")
        tvDisplayPhoneNumber?.setText("Phone Number : $phoneNumber")
        tvDisplayMarks?.setText("Marks : $marks")
        tvDisplayPercentage?.setText("Percentage : $percentage")
        cbIAgree?.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                //Toast.makeText(this, "Checked", Toast.LENGTH_LONG).show()
                btnContinue?.setOnClickListener {
                    var intent = Intent(this, CheckboxRadioActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            } else {
                //Toast.makeText(this, "Error! Not checked", Toast.LENGTH_SHORT).show()
                cbIAgree?.error = "Please select above filed."
            }
        }
        btnBack?.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}