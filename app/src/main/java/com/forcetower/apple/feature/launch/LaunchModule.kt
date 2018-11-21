package com.forcetower.apple.feature.launch

import androidx.lifecycle.ViewModel
import com.forcetower.apple.core.injection.annotation.FragmentScoped
import com.forcetower.apple.core.injection.annotation.ViewModelKey
import com.forcetower.apple.feature.launch.subject.SubjectFragment
import com.forcetower.apple.feature.launch.subject.SubjectViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class LaunchModule {
    @Binds
    @IntoMap
    @ViewModelKey(SubjectViewModel::class)
    internal abstract fun bindSubjectViewModel(viewModel: SubjectViewModel): ViewModel

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun bindSubjectFragment(): SubjectFragment
}