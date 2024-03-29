package com.example.stressmeter.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.stressmeter.R
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.util.*


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
            if (bundle != null) {
                val file = File(getExternalFilesDir(null), "StressLevels.csv")
                if (!file.exists()) {
                    file.createNewFile()
                }

                val fileWriter = FileWriter(file, true)
                val buffWriter = BufferedWriter(fileWriter)
                buffWriter.append(Date().time.toString()).append(",")
                buffWriter.append(bundle.getInt("Score").toString()).append("\n")
                buffWriter.flush()
                buffWriter.close()
            }

            setResult(RESULT_OK, Intent())
            finish()
        }
    }
}