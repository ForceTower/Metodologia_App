package com.forcetower.apple.feature.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.forcetower.apple.databinding.FragmentStartBinding

class StartFragment: Fragment() {
    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentStartBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val subjectAdapter = SubjectAdapter(this, null)
        binding.subjectsRecycler.apply {
            adapter = subjectAdapter
            itemAnimator?.run {
                addDuration = 120L
                moveDuration = 120L
                changeDuration = 120L
                removeDuration = 100L
            }
        }
        //TODO Comecar a observar os assuntos aqui
        //TODO subjectAdapter.submitList(A Lista)
    }
}