package com.workassociate.wa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.workassociate.wa.ui.home.HomeActivity
import com.workassociate.wa.ui.login.LoginActivity
import com.workassociate.wa.utils.IntentUtil
import com.workassociate.wa.utils.SharePreData

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        init()
    }

    private fun init() {
        //Moving to Home screen
        Handler(Looper.getMainLooper()).postDelayed({
            if (SharePreData.getLoginStatus(this))
                IntentUtil.startActivity(this, HomeActivity::class.java, true)
            else
                IntentUtil.startActivity(this, LoginActivity::class.java, true)
        }, 3000)
    }
}