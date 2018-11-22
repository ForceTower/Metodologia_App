package com.forcetower.apple.feature.launch.subject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.forcetower.apple.core.data.SubjectRepository
import com.forcetower.apple.core.model.Subject
import com.forcetower.apple.feature.Event
import javax.inject.Inject

class SubjectViewModel @Inject constructor(
    private val repository: SubjectRepository
): ViewModel(), SubjectActions {
    val subjects: LiveData<List<Subject>> by lazy { repository.subjects }

    private val _navigateToSubjectAction = MutableLiveData<Event<Subject>>()
    val navigateToSubjectAction: LiveData<Event<Subject>>
        get() = _navigateToSubjectAction

    override fun onSubjectSelected(subject: Subject) {
        _navigateToSubjectAction.value = Event(subject)
    }
}