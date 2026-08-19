package com.sportingcristal.tema

import android.app.WallpaperManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class WallpaperActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallpaper)

        val btnApply = findViewById<Button>(R.id.btn_apply_wallpaper)
        val btnLock  = findViewById<Button>(R.id.btn_apply_lockscreen)
        val btnBoth  = findViewById<Button>(R.id.btn_apply_both)

        btnApply.setOnClickListener { applyHome() }
        btnLock.setOnClickListener  { applyLock() }
        btnBoth.setOnClickListener  { applyHome(); applyLock() }
    }

    private fun applyHome() {
        try {
            val wm = WallpaperManager.getInstance(this)
            val bmp = android.graphics.BitmapFactory.decodeResource(resources, R.drawable.wallpaper_sc)
            wm.setBitmap(bmp, null, true, WallpaperManager.FLAG_SYSTEM)
            Toast.makeText(this, "✅ Fondo de inicio aplicado!", Toast.LENGTH_SHORT).show()
        } catch(e: Exception) {
            Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun applyLock() {
        try {
            val wm = WallpaperManager.getInstance(this)
            val bmp = android.graphics.BitmapFactory.decodeResource(resources, R.drawable.lockscreen_sc)
            wm.setBitmap(bmp, null, true, WallpaperManager.FLAG_LOCK)
            Toast.makeText(this, "✅ Pantalla de bloqueo aplicada!", Toast.LENGTH_SHORT).show()
        } catch(e: Exception) {
            Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
}
