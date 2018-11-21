package com.forcetower.apple.feature.launch

import androidx.lifecycle.ViewModel
import com.forcetower.apple.core.injection.annotation.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Tudo que for necessario injetar no contexto da atividade, os fragmentos, ViewModels... essas coisas
 */
@Module
internal abstract class LaunchModule {
//    @Binds
//    @IntoMap
//    @ViewModelKey(LaunchViewModel::class)
//    internal abstract fun bindLaunchViewModel(viewModel: LaunchViewModel): ViewModel
}