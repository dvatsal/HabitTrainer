package com.loveservesolutions.habittrainer

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class HabitsAdapter(val habits:List<Habit>):RecyclerView.Adapter<HabitsAdapter.HabitViewHolder>(){

    class HabitViewHolder(val iv:View) : RecyclerView.ViewHolder(iv)

    //Create new view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_card, parent)
        return HabitViewHolder(view)
    }

    override fun getItemCount() = habits.size

    override fun onBindViewHolder(holder: HabitViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}