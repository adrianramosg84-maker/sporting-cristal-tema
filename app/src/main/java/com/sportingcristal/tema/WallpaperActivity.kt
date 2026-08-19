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

        findViewById<Button>(R.id.btn_apply_wallpaper).setOnClickListener {
            applyWallpaper(WallpaperManager.FLAG_SYSTEM, R.drawable.wallpaper_sc)
        }
        findViewById<Button>(R.id.btn_apply_lockscreen).setOnClickListener {
            applyWallpaper(WallpaperManager.FLAG_LOCK, R.drawable.lockscreen_sc)
        }
        findViewById<Button>(R.id.btn_apply_both).setOnClickListener {
            applyWallpaper(WallpaperManager.FLAG_SYSTEM, R.drawable.wallpaper_sc)
            applyWallpaper(WallpaperManager.FLAG_LOCK, R.drawable.lockscreen_sc)
        }
    }

    private fun applyWallpaper(flag: Int, resId: Int) {
        try {
            val wm = WallpaperManager.getInstance(this)
            val bmp = android.graphics.BitmapFactory.decodeResource(resources, resId)
            wm.setBitmap(bmp, null, true, flag)
            Toast.makeText(this, "Aplicado!", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
}
