package com.forcetower.apple.core.injection.module

import com.forcetower.apple.core.model.Subject
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Named

@Module
class CoreModule {
    @Provides
    @Reusable
    fun provideFirestore(): FirebaseFirestore {
        val settings = FirebaseFirestoreSettings.Builder()
            .setPersistenceEnabled(true)
            .setTimestampsInSnapshotsEnabled(true)
            .build()

        return FirebaseFirestore.getInstance().apply {
            firestoreSettings = settings
        }

    }

    @Provides
    @Reusable
    @Named(Subject.COLLECTION)
    fun provideSubjectCollection(firestore: FirebaseFirestore) = firestore.collection(Subject.COLLECTION)
}
