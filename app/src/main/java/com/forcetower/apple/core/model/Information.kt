package com.forcetower.apple.core.model

data class Information(
    var id: String = "",
    var order: Int = 0,
    var text: String? = null,
    var subtitle: String? = null,
    var image: String? = null
) {
    companion object {
        const val COLLECTION = "information"
    }
}