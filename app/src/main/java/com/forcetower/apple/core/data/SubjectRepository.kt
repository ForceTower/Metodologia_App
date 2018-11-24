package com.forcetower.apple.core.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.forcetower.apple.core.model.Information
import com.forcetower.apple.core.model.Subject
import com.google.firebase.firestore.CollectionReference
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class SubjectRepository @Inject constructor(
    @Named(Subject.COLLECTION) private val collection: CollectionReference
) {
    val subjects: LiveData<List<Subject>>
        get() = allSubjects()

    private fun allSubjects(): LiveData<List<Subject>> {
        val data = MutableLiveData<List<Subject>>()
        collection.addSnapshotListener { snapshot, exception ->
            if (exception != null) {
                Timber.d("Exception on document read")
                Timber.e(exception)
            } else {
                if (snapshot != null) {
                    val list = snapshot.documents
                        .map { it.toObject(Subject::class.java)!!.apply { id = it.id } }
                        .sortedBy { it.order }
                    data.postValue(list)
                } else {
                    data.postValue(emptyList())
                }
            }
        }
        return data
    }

    fun subject(id: String): LiveData<Subject> {
        val data = MutableLiveData<Subject>()
        collection.document(id).addSnapshotListener { snapshot, exception ->
            if (exception != null) {
                Timber.d("Exception on document read")
                Timber.e(exception)
            } else {
                if (snapshot != null) {
                    val value = snapshot.toObject(Subject::class.java)!!
                    value.id = snapshot.id
                    data.postValue(value)
                } else {
                    Timber.d("Snapshot is null... Does the document exists?")
                }
            }
        }
        return data
    }

    fun information(subject: String): LiveData<List<Information>> {
        val data = MutableLiveData<List<Information>>()
        collection.document(subject).collection(Information.COLLECTION).addSnapshotListener { snapshot, exception ->
            if (exception != null) {
                Timber.d("Exception on document read")
                Timber.e(exception)
            } else {
                if (snapshot != null) {
                    val list = snapshot.documents
                        .map { it.toObject(Information::class.java)!!.apply { id = it.id } }
                        .sortedBy { it.order }
                    data.postValue(list)
                } else {
                    data.postValue(emptyList())
                }
            }
        }
        return data
    }

}