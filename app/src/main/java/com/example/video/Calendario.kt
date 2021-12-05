package com.example.video

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.CalendarView
import android.widget.Toast

class Calendario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendario)

        val calendar = findViewById<CalendarView>(R.id.calendarView)
        calendar.setOnDateChangeListener{view: CalendarView, year: Int, month: Int, dayOfMonth: Int ->
            Toast.makeText(this@Calendario, "Fecha: $dayOfMonth/$month/$year", Toast.LENGTH_LONG).show()
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