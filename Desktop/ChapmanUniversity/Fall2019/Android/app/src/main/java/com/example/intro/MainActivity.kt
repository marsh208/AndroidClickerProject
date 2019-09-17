package com.example.intro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    var count = 0;

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.run {
            putString("counter", counter.text.toString())
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        counter.text = savedInstanceState?.getString("counter")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var tempCount = savedInstanceState?.getString("counter");
        if (tempCount != null) {
            count = tempCount.toInt()
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
            counter.text = count.toString();
        }
    }
}
