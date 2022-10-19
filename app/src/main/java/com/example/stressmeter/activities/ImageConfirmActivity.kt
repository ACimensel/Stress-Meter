package com.example.stressmeter.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.stressmeter.R


class ImageConfirmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_confirm)

        val image = findViewById<ImageView>(R.id.image_confirm)
        val btnCancel = findViewById<Button>(R.id.btn_cancel)
        val btnSubmit = findViewById<Button>(R.id.btn_submit)

        val bundle = intent.extras
        if (bundle != null) {
            val picture = bundle.getInt("Image")
            image.setImageResource(picture)
        }

        btnCancel.setOnClickListener{
            setResult(RESULT_CANCELED, Intent())
            finish()
        }

        btnSubmit.setOnClickListener{
//            if (bundle != null) {
//                Toast.makeText(this, bundle.getInt("Score").toString(),Toast.LENGTH_LONG).show()
//            }

            setResult(RESULT_OK, Intent())
            finish()
        }
    }
}