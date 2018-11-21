package com.forcetower.apple.core.injection

import com.forcetower.apple.core.injection.annotation.ActivityScoped
import com.forcetower.apple.feature.launch.LaunchModule
import com.forcetower.apple.feature.launch.LauncherActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [LaunchModule::class])
    internal abstract fun launcherActivity(): LauncherActivity
}