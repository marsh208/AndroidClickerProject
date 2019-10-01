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
    private var userName: String = ""

    fun getStore() = getPreferences(Context.MODE_PRIVATE)

    override fun onPause(){
        super.onPause()
        getStore().edit().putInt(getUserName(), count).apply()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.run {
            putString(getUserName(), counter.text as String?)
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        counter.text = savedInstanceState?.getString(getUserName())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var username = intent.extras?.get("username")
        MainUsername.text = username.toString()
        setUserName(username.toString())


        var tempCount = getStore().getInt(userName, 0)
        if (tempCount != 0) {
            count = tempCount
            counter.text = count.toString()
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

    private fun setUserName(username: String)
    {
        this.userName = username
    }

    private fun getUserName(): String
    {
        return this.userName
    }
}
