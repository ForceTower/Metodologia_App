package com.forcetower.apple.feature.launch

import android.os.Bundle
import com.forcetower.apple.R
import dagger.android.support.DaggerAppCompatActivity

class LauncherActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
    }
}
