package com.loveservesolutions.habittrainer

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //adapter - defines data
        //Recycler view implements 3 methods
        rv.setHasFixedSize(true)
        rv.layoutManager  = LinearLayoutManager(this)
        rv.adapter = HabitsAdapter(getSampleHabits())
            }
}
