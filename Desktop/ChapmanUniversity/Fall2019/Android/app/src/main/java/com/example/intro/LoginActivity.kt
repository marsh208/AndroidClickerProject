package com.example.intro

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.intro.MainActivity
import kotlinx.android.synthetic.main.activity_login.*
import com.bumptech.glide.Glide

class LoginActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Glide.with(this).load("https://images.app.goo.gl/9tkrosDzyvGh7Z2V8").into(glideImage)

        loginUsernameField.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //unused
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //do this -- check docs (i.e. username > 6 characters)
            }

            override fun afterTextChanged(p0: Editable?) {
                //unused
            }
        })



        loginGoButton.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java).apply { putExtra("username",loginUsernameField.text) })
        }




    }

}

