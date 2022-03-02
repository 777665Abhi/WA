package com.workassociate.wa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.workassociate.wa.ui.home.HomeActivity
import com.workassociate.wa.ui.login.LoginActivity
import com.workassociate.wa.utils.IntentUtil
import com.workassociate.wa.utils.SharePreData

import androidx.databinding.DataBindingUtil
import com.workassociate.wa.databinding.ActivitySplashBinding


class SplashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =DataBindingUtil.setContentView(this, R.layout.activity_splash)
        init()
    }

    private fun init() {
        //Setting animation
        var animSequential = AnimationUtils.loadAnimation(applicationContext, R.anim.left_right)
        animSequential.fillBefore = true
        animSequential.fillAfter = true
        binding.ivImage.animation=animSequential

        //Moving to Home screen
        Handler(Looper.getMainLooper()).postDelayed({
            if (SharePreData.getLoginStatus(this))
                IntentUtil.startActivity(this, HomeActivity::class.java, true)
            else
                IntentUtil.startActivity(this, LoginActivity::class.java, true)
        }, 3000)
    }
}