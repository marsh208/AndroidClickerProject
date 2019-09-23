package com.example.intro

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    private var count: Int = 0
    fun getStore() = getPreferences(Context.MODE_PRIVATE)

    override fun onPause(){
        super.onPause()
        getStore().edit().putInt("counter", count).apply()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.run {
            putString("counter", counter.text as String?)
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        counter.text = savedInstanceState?.getString("counter")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var username = intent.extras?.get("username")

        MainUsername.text = username as CharSequence?

        var tempCount = getStore().getInt("counter", 0)
        if (tempCount != null) {
            count = tempCount
        }
        myButton.setOnClickListener{
            count = count + 1;
            if(image.isVisible)
            {
                image.visibility = View.GONE
            }
            else
            {
                image.visibility = View.VISIBLE
            }
            counter.text = count.toString()
        }
    }
}
