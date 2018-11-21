package com.forcetower.apple.core.model

data class Subject(
    var id: String = "",
    var title: String,
    var subtitle: String,
    var image: String
) {
    override fun toString() = title
    companion object {
        const val COLLECTION = "subjects"
    }
}