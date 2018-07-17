package com.loveservesolutions.habittrainer

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.single_card.view.*

class HabitsAdapter(val habits:List<Habit>):RecyclerView.Adapter<HabitsAdapter.HabitViewHolder>(){

    class HabitViewHolder(val card:View) : RecyclerView.ViewHolder(card)

    //Create new view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_card, parent,false)//java.lang.IllegalStateException: The specified child already has a parent. You must call removeView() on the child's parent first.--false-attachToRoot was passed to resolve this fatal exception
        return HabitViewHolder(view)
    }

    override fun getItemCount() = habits.size

    //Specifies content to be shown
    override fun onBindViewHolder(holder: HabitViewHolder?, index: Int) {
        if(holder!=null)
        {
            holder.card.tv_title.text = habits[index].title
            holder.card.tv_description.text = habits[index].description
            holder.card.iv_icon.setImageResource(habits[index].image)

        }
    }
}