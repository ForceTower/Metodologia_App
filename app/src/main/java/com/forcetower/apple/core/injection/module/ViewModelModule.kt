package com.forcetower.apple.core.injection.module

import androidx.lifecycle.ViewModelProvider
import com.forcetower.apple.core.vm.PViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: PViewModelFactory): ViewModelProvider.Factory
}