package com.loveservesolutions.habittrainer

import android.content.Intent
import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View

class CreateHabitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_habit)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.add_habit){
            switchActivity(CreateHabitActivity::class.java)

        }
        return true
    }

    private fun switchActivity(c:Class<*>) {
        val intent = Intent(this, c)
        startActivity(intent)
    }

    fun chooseImage(v:View){
        val intent = Intent()
        intent.type ="image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        val chooser = Intent.createChooser(intent, "Choose image for habit")
        startActivity(chooser)
    }
}
