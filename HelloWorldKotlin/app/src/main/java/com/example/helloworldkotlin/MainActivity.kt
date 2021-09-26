package com.example.helloworldkotlin
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity() {

    var videoView: VideoView? = null
    var mediaController:MediaController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        videoView = findViewById<View>(R.id.videoView) as VideoView?
        if(mediaController == null ){
            mediaController = MediaController(this)
            mediaController!!.setAnchorView(this.videoView)
        }
        videoView!!.setMediaController(mediaController)
        videoView!!.setVideoURI(Uri.parse("android.resource://"+ packageName+ "/" + R.raw.yt5s))
        videoView!!.requestFocus()
        videoView!!.start()

        val button = findViewById<Button>(R.id.button) //btn Try me
        button.setOnClickListener{ // go to the other page when click the btn
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

    }

}
