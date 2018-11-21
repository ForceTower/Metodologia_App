package com.forcetower.apple.core.injection

import com.forcetower.apple.PApplication
import com.forcetower.apple.core.injection.module.AppModule
import com.forcetower.apple.core.injection.module.CoreModule
import com.forcetower.apple.core.injection.module.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBindingModule::class,
        ViewModelModule::class,
        CoreModule::class
    ]
)
interface AppComponent: AndroidInjector<PApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<PApplication>()
}