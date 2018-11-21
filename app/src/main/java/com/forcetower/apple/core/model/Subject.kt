package com.forcetower.apple.core.model

//Esta classe vem do backend, provavelmente o firebase... tenho que pensar
data class Subject(
    var title: String,
    var subtitle: String,
    var image: String
) {
    override fun toString() = title
    companion object {
        const val COLLECTION = "subjects"
    }
}