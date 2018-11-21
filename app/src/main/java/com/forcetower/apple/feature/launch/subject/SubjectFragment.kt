package com.forcetower.apple.feature.launch.subject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.forcetower.apple.databinding.FragmentStartBinding
import com.forcetower.apple.feature.shared.provideActivityViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class SubjectFragment: DaggerFragment() {
    @Inject lateinit var factory: ViewModelProvider.Factory
    private lateinit var binding: FragmentStartBinding
    private lateinit var subjectVM: SubjectViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        subjectVM = provideActivityViewModel(factory)
        return FragmentStartBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val subjectAdapter = SubjectAdapter(this, subjectVM)
        binding.subjectsRecycler.apply {
            adapter = subjectAdapter
            itemAnimator?.run {
                addDuration = 120L
                moveDuration = 120L
                changeDuration = 120L
                removeDuration = 100L
            }
        }
        subjectVM.subjects.observe(this, Observer { subjectAdapter.submitList(it) })
    }
}