package com.example.clickerandroidarchitecture.ui

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.clickerandroidarchitecture.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginUsernameField.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // unused
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // unused
            }

            override fun afterTextChanged(p0: Editable?) {
                //unused
            }
        })



        loginGoButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java).apply {
                putExtra(
                    "username",
                    loginUsernameField.text
                )
            })


        }
    }

}
