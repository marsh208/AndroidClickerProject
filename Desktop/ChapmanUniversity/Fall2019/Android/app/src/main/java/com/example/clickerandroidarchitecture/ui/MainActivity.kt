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

class MainActivity : AppCompatActivity() {

    private lateinit var countViewModel: CountViewModel
    private var count: Long = 0;
    private fun getUsername() = intent.extras?.get("username").toString().toLowerCase(Locale.US)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        countViewModel = ViewModelProviders.of(this).get(countViewModel::class.java)
        countViewModel.getUserCount(getUsername()).observe(this,
            androidx.lifecycle.Observer { updateCounter(it) })

        myButton.setOnClickListener {
            countViewModel.setUserCount(getUsername(), count + 1)
        }
    }

    private fun updateCounter(c: Long)
    {

        count = c;
        counter.text = count.toString()
    }
}
