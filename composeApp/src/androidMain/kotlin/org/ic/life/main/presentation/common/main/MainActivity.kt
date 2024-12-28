package org.ic.life.main.presentation.common.main

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.ic.life.main.SerialBluetoothApp

class MainActivity : ComponentActivity() {

    private var keepOnScreenCondition = true
    private fun runSplashScreen() {
        lifecycleScope.launch {
            delay(3000)
            keepOnScreenCondition = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        runSplashScreen()
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                keepOnScreenCondition
            }

            setOnExitAnimationListener { screen ->
                val zoomX = ObjectAnimator.ofFloat(screen.iconView, View.SCALE_X, 0.4f, 0.0f)

                zoomX.interpolator = OvershootInterpolator()
                zoomX.duration = 1000
                zoomX.doOnEnd { screen.remove() }

                val zoomY = ObjectAnimator.ofFloat(screen.iconView, View.SCALE_Y, 0.4f, 0.0f)

                zoomY.interpolator = OvershootInterpolator()
                zoomY.duration = 1000
                zoomY.doOnEnd { screen.remove() }

                val opacity = ObjectAnimator.ofFloat(screen.iconView, View.ALPHA, 1f, 0f)
                opacity.duration = 200
                opacity.doOnEnd { screen.remove() }

                zoomX.start()
                zoomY.start()
                opacity.start()
            }
        }
        enableEdgeToEdge()
        val insetsController = WindowCompat.getInsetsController(window, window.decorView)
        insetsController.apply {
            hide(WindowInsetsCompat.Type.statusBars())
            hide(WindowInsetsCompat.Type.navigationBars())
            systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
        setContent {
            SerialBluetoothApp()
        }
    }
}
