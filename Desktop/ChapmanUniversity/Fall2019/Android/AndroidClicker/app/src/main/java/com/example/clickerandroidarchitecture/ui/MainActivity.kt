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
import android.provider.MediaStore
import com.bumptech.glide.Glide
import com.example.clickerandroidarchitecture.Gif
import com.example.clickerandroidarchitecture.viewmodel.GifViewModel
import com.facebook.drawee.backends.pipeline.Fresco
import com.giphy.sdk.core.models.Media
import com.giphy.sdk.core.models.enums.RenditionType
import com.giphy.sdk.ui.GPHContentType
import com.giphy.sdk.ui.GPHSettings
import com.giphy.sdk.ui.GiphyCoreUI
import com.giphy.sdk.ui.themes.GridType
import com.giphy.sdk.ui.themes.LightTheme
import com.giphy.sdk.ui.views.GPHMediaView
import com.giphy.sdk.ui.views.GifView
import com.giphy.sdk.ui.views.GiphyDialogFragment
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    private lateinit var countViewModel: CountViewModel
    private lateinit var gifViewModel: GifViewModel

    private var count: Long = 0;
    private fun getUsername() = intent.extras?.get("username").toString().toLowerCase(Locale.US)
//    private var pics = arrayOf(R.mipmap.bacon, R.mipmap.french, R.mipmap.fluff, R.mipmap.boxer, R.mipmap.chihuaua, R.mipmap.husky)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val context = this
        setContentView(R.layout.activity_main)

        //giphy
//        GiphyCoreUI.configure(this, "YdwxPNt3JQbgS8rKBDs3hawt4BhmmwHW")
//        var settings = GPHSettings(gridType = GridType.waterfall, theme = LightTheme, dimBackground = true)
//        val gifsDialog = GiphyDialogFragment.newInstance(settings)
//        settings.mediaTypeConfig = arrayOf(GPHContentType.gif)
//        gifsDialog.show(supportFragmentManager, "gifs_dialog")


//        gifsDialog.gifSelectionListener = object: GiphyDialogFragment.GifSelectionListener {
//            override fun onGifSelected(media: Media) {
//
//                image.setMedia(media, RenditionType.original)
//            }
//
//            override fun onDismissed() {
//                //Your user dismissed the dialog without selecting a GIF
//            }
//        }



        welcomeUser.text = (welcomeUser.text).toString() + getUsername()

        //count view model
        countViewModel = ViewModelProviders.of(this).get(CountViewModel::class.java)
        countViewModel.getUserCount(getUsername()).observe(this,
            androidx.lifecycle.Observer { updateCounter(it) })

        //gif view model
        gifViewModel = ViewModelProviders.of(this).get(GifViewModel::class.java)
        gifViewModel.getRandomGif("android").observe(this,
            androidx.lifecycle.Observer { loadGif(it) })



        myButton.setOnClickListener {
            countViewModel.setUserCount(getUsername(), count + 1)
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

    private fun loadGif(gif: Gif){
        Glide.with(this)
            .load(gif.url)
            .into(image)

    }
}

