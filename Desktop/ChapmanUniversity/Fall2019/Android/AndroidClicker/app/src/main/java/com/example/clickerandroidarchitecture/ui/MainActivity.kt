package com.example.clickerandroidarchitecture.ui


import com.example.clickerandroidarchitecture.viewmodel.CountViewModel
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import com.example.clickerandroidarchitecture.R
import java.util.*
import android.graphics.drawable.RotateDrawable
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    private lateinit var countViewModel: CountViewModel
    private var count: Long = 0;
    private fun getUsername() = intent.extras?.get("username").toString().toLowerCase(Locale.US)
    private var pics = arrayOf(R.mipmap.bacon, R.mipmap.french, R.mipmap.fluff, R.mipmap.boxer, R.mipmap.chihuaua, R.mipmap.husky)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        welcomeUser.text = (welcomeUser.text).toString() + getUsername()


        countViewModel = ViewModelProviders.of(this).get(CountViewModel::class.java)
        countViewModel.getUserCount(getUsername()).observe(this,
            androidx.lifecycle.Observer { updateCounter(it) })

        myButton.setOnClickListener {
            countViewModel.setUserCount(getUsername(), count + 1)
            image.setImageResource(pics[nextInt(0,5)])
        }

        resetButton.setOnClickListener{
            countViewModel.setUserCount(getUsername(), 0)
            count = 0
        }
    }

    private fun updateCounter(c: Long)
    {
        count = c;
        counter.text = count.toString()
    }
}

