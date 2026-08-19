package com.sportingcristal.tema

import android.app.WallpaperManager
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_wallpaper).setOnClickListener {
            try {
                val wm = WallpaperManager.getInstance(this)
                val bmp = android.graphics.BitmapFactory.decodeResource(resources, R.drawable.wallpaper_sc)
                wm.setBitmap(bmp, null, true, WallpaperManager.FLAG_SYSTEM)
                Toast.makeText(this, "Fondo aplicado!", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.btn_screens).setOnClickListener {
            startActivity(Intent(this, WallpaperActivity::class.java))
        }
    }
}
