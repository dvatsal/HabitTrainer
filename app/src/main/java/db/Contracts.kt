package db

import android.provider.BaseColumns

val DATABASE_NAME = "habittrainer.db"
val DATABASE_VERSION = 1

object HabitEntry:BaseColumns{
    val _ID = "id"
    val TABLE_NAME = "habit"
    val TITLE_COL = "title"
    val DESCR_COL = "description"
    val IMAGE_COL = "image"
}