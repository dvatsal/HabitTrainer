package com.loveservesolutions.habittrainer

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.media.Image
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_create_habit.*

public fun EditText.isBlank():Boolean = this.toString().isBlank()

class CreateHabitActivity : AppCompatActivity() {

    private val TAG = CreateHabitActivity::class.simpleName

    private val CHOOSE_IMAGE_REQUEST = 1

    private var imageBitmap :Bitmap? = null



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

    fun storeHabit(v: View){
        if(et_title.isBlank() || et_description.isBlank()){
            Log.d(TAG,"Habit Details are missing")
            displayErrorMessage("Habit details are missing")
            return

        }
        else if(imageBitmap==null){
            Log.d(TAG,"Image not selected")
            displayErrorMessage("image missing")
            return

        }

        et_error.visibility = View.INVISIBLE
    }
    fun displayErrorMessage(message:String){

        et_error.text = message
        et_error.visibility = View.VISIBLE


    }
    fun chooseImage(v:View){
        val intent = Intent()
        intent.type ="image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        val chooser = Intent.createChooser(intent, "Choose image for habit")

        //startActivity(chooser, CHOOSE_IMAGE_REQUEST)
        startActivityForResult(chooser,CHOOSE_IMAGE_REQUEST)
        Log.d(TAG, "Intent to choose image sent ...")
    }

    /**
     * Dispatch incoming result to the correct fragment.
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==CHOOSE_IMAGE_REQUEST && resultCode== Activity.RESULT_OK && data!=null && data.data!=null)
        {
            Log.d(TAG, "User chose an image")
            val bitmap = tryReadBitmap(data.data)
            bitmap?.let {
                imageBitmap = bitmap
                iv_image_preview.setImageBitmap(bitmap)
                Log.d(TAG,"Read image bitmap and updated the image view")
            }
        }
    }

    private fun tryReadBitmap(data: Uri): Bitmap? {

        return try {
            MediaStore.Images.Media.getBitmap(contentResolver,data)
        }catch (e:Exception){

            e.printStackTrace()
            return null
        }

    }
}

