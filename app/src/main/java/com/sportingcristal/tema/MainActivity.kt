package com.sportingcristal.tema

import android.app.WallpaperManager
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Botón aplicar wallpaper
        val btnWallpaper = findViewById<Button>(R.id.btn_wallpaper)
        btnWallpaper.setOnClickListener {
            applyWallpaper()
        }

        // Botón ver pantallas
        val btnScreens = findViewById<Button>(R.id.btn_screens)
        btnScreens.setOnClickListener {
            startActivity(Intent(this, WallpaperActivity::class.java))
        }
    }

    private fun applyWallpaper() {
        try {
            val wallpaperManager = WallpaperManager.getInstance(this)
            val drawable = resources.getDrawable(R.drawable.wallpaper_sc, theme)
            wallpaperManager.drawable = drawable
            Toast.makeText(this,
                "¡Fondo de pantalla Sporting Cristal aplicado! ⚽",
                Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
            Toast.makeText(this,
                "Error al aplicar: ${e.message}",
                Toast.LENGTH_SHORT).show()
        }
    }
}
