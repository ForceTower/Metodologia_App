package com.forcetower.apple.feature.launch.subject

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.forcetower.apple.core.data.SubjectRepository
import com.forcetower.apple.core.model.Subject
import javax.inject.Inject

class SubjectViewModel @Inject constructor(
    private val repository: SubjectRepository
): ViewModel(), SubjectActions {
    val subjects: LiveData<List<Subject>> by lazy { repository.subjects }

    override fun onSubjectSelected(subject: Subject) {

    }
}