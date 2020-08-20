package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)?.ifEmpty() { null }
        val lastName = parts?.getOrNull(1)?.ifEmpty() { null }

        return firstName to lastName
    }
}