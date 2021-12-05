package com.example.video

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val videoView = findViewById<VideoView>(R.id.reproductor)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        val lofi1 = Uri.parse("android.resource://$packageName/${R.raw.lofi1}")
        val lofi2 = Uri.parse("android.resource://$packageName/${R.raw.lofi2}")
        val lofi3 = Uri.parse("android.resource://$packageName/${R.raw.lofi3}")

        videoView.setMediaController(mediaController)
        videoView.setVideoURI(lofi1)
        videoView.requestFocus()
        videoView.start()

        val arrayAdapter : ArrayAdapter<*>
        val videos = mutableListOf("Lofi hip hop 1","Lofi hip hop 2","Lofi hip hop 3")
        val list = findViewById<ListView>(R.id.lista)

        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, videos)
        list.adapter = arrayAdapter

        list.setOnItemClickListener(){ parent, view, position, id ->
            var name = parent.getItemAtPosition(position).toString()

            if (name.equals(videos[0])){
                videoView.stopPlayback()
                videoView.setVideoURI(lofi1)
                videoView.requestFocus()
                videoView.start()
            } else if (name.equals(videos[1])){
                videoView.stopPlayback()
                videoView.setVideoURI(lofi2)
                videoView.requestFocus()
                videoView.start()
            }else if (name.equals(videos[2])){
                videoView.stopPlayback()
                videoView.setVideoURI(lofi3)
                videoView.requestFocus()
                videoView.start()
            }

        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){

            R.id.video -> {
                startActivity(Intent(this, MainActivity::class.java))
                true
            }
            R.id.calendario -> {
                startActivity(Intent(this, Calendario::class.java))
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

}