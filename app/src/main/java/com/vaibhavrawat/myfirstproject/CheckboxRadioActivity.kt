package com.vaibhavrawat.myfirstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast

class CheckboxRadioActivity : AppCompatActivity() {
    var cbIAgree : CheckBox?= null
    var btnSubmit : Button?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox_radio)
        cbIAgree = findViewById(R.id.cbIAgree)
        btnSubmit = findViewById(R.id.btnSubmit)
        cbIAgree?.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                Toast.makeText(this, "Checked", Toast.LENGTH_LONG).show()
                btnSubmit?.setOnClickListener {
                    var intent = Intent(this, Testing::class.java)
                    startActivity(intent)
                    finish()
                }
            }else{
                Toast.makeText(this, "Error! Not checked", Toast.LENGTH_SHORT).show()
                cbIAgree?.error = "Please select above filed."
            }

        }


    }
}


