package com.forcetower.apple.feature.launch.topic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.forcetower.apple.databinding.FragmentInformationBinding
import com.forcetower.apple.feature.shared.provideActivityViewModel
import com.forcetower.apple.feature.shared.provideViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class InformationFragment: DaggerFragment() {
    @Inject lateinit var factory: ViewModelProvider.Factory
    private lateinit var binding: FragmentInformationBinding
    private lateinit var informationVM: InformationViewModel
    private lateinit var subjectId: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        informationVM = provideViewModel(factory)
        subjectId = requireNotNull(arguments).getString("subject_id")?: "invalid"
        informationVM.setSubject(subjectId)
        return FragmentInformationBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.up.setOnClickListener { findNavController().popBackStack() }

        val informationAdapter = InformationAdapter()
        binding.informationRecycler.apply {
            adapter = informationAdapter
        }

        informationVM.subject.observe(this, Observer { informationAdapter.subject = it })
        informationVM.information.observe(this, Observer { informationAdapter.informations = it })
    }

    companion object {
        fun createInstance(id: String): InformationFragment {
            return InformationFragment().apply {
                arguments = bundleOf("subject_id" to id)
            }
        }
    }
}