package com.forcetower.apple.feature.launch

import android.os.Bundle
import androidx.navigation.findNavController
import com.forcetower.apple.R
import dagger.android.support.DaggerAppCompatActivity

class LauncherActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
    }

    override fun onSupportNavigateUp() = findNavController(R.id.nav_host_fragment).navigateUp()
}
