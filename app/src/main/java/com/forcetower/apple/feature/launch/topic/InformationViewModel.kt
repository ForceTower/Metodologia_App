package com.forcetower.apple.feature.launch.topic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.forcetower.apple.core.data.SubjectRepository
import com.forcetower.apple.core.model.Information
import com.forcetower.apple.core.model.Subject
import com.forcetower.apple.feature.shared.setValueIfNew
import javax.inject.Inject

class InformationViewModel @Inject constructor(
    private val repository: SubjectRepository
): ViewModel() {
    private val subjectId = MutableLiveData<String?>()

    private val _subject = MediatorLiveData<Subject>()
    val subject: LiveData<Subject>
        get() = _subject

    private val _information = MediatorLiveData<List<Information>>()
    val information: LiveData<List<Information>>
        get() = _information

    init {
        _subject.addSource(subjectId) { id ->
            if (id != null) {
                val src = repository.subject(id)
                _subject.addSource(src) {
                    _subject.value = it
                }
            }
        }
        _information.addSource(subjectId) { id ->
            if (id != null) {
                val src = repository.information(id)
                _information.addSource(src) {
                    _information.value = it
                }
            }
        }
    }

    fun setSubject(id: String?) {
        subjectId.setValueIfNew(id)
    }
}