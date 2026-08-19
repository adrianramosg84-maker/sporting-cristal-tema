package com.sportingcristal.tema

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Animación del escudo
        val shield = findViewById<ImageView>(R.id.splash_shield)
        val title  = findViewById<TextView>(R.id.splash_title)
        val sub    = findViewById<TextView>(R.id.splash_subtitle)
        val stars  = findViewById<TextView>(R.id.splash_stars)

        val popIn   = AnimationUtils.loadAnimation(this, R.anim.pop_in)
        val fadeUp  = AnimationUtils.loadAnimation(this, R.anim.fade_up)
        val starAnim= AnimationUtils.loadAnimation(this, R.anim.star_pulse)

        stars.startAnimation(starAnim)
        shield.startAnimation(popIn)
        title.startAnimation(fadeUp)
        sub.startAnimation(fadeUp)

        // Ir a MainActivity después de 3 segundos
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 3000)
    }
}
