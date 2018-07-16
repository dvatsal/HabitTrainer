package com.loveservesolutions.habittrainer

data class Habit(val title: String,val description:String,val image:Int)

fun getSampleHabits():List<Habit>{

    val Habits:List<Habit> = listOf(
            Habit("Go for a walk",
                "Going for a walk keeps you healthy",
                R.drawable.walk),
        Habit("Drink a water","Drinking a glass full of water keeps body hyderated",R.drawable.water))

return Habits
}