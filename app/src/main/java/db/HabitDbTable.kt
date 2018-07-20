package db

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import com.loveservesolutions.habittrainer.Habit

class HabitDbTable(context: Context){

    private val dbHelper = HabitTrainerDB(context)
    private val TAG = HabitDbTable::class.simpleName

    fun store(habit:Habit):Long{

            val db = dbHelper.writableDatabase
            val values = ContentValues()
            values.put(HabitEntry.TITLE_COL,habit.title)
            values.put(HabitEntry.DESCR_COL,habit.description)
            values.put(HabitEntry.IMAGE_COL,toByteArray(habit.image))

//        db.beginTransaction()
//        var id  = try {
//
//            db.insert(HabitEntry.TABLE_NAME, null, values)
//            db.setTransactionSuccessful()
//        }finally {
//            db.endTransaction()
//        }
//            db.close()
//            Log.d(TAG,"Stored operation done and db closed ${habit}")
//
        return 1
    }

    fun toByteArray(bitmap:Bitmap):Byte
    {
    
    }
}
