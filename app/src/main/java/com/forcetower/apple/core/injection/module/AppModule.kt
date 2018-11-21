package com.forcetower.apple.core.injection.module

import android.content.Context
import com.forcetower.apple.PApplication
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    fun provideContext(application: PApplication): Context {
        return application.applicationContext
    }



}