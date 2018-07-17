package com.loveservesolutions.habittrainer

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

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
}
