package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User(
        val id: String,
        val firstName: String?,
        val lastName: String?,
        var avatar: String?,
        var rating: Int = 0,
        val lastVisit: Date? = null,
        val isOnline: Boolean = false
) {
    constructor(id: String, firstName: String?, lastName: String?) : this(
            id = id,
            firstName = firstName,
            lastName = lastName,
            avatar = null
    )

    constructor(id: String) : this(id, "John", "Doe")

    private constructor(builder: Builder) : this(
            builder.id,
            builder.firstName,
            builder.lastName,
            builder.avatar,
            builder.rating,
            builder.lastVisit,
            builder.isOnline
    )

    companion object Factory {
        private var lastId: Int = -1

        fun makeUser(fullname: String?): User {
            lastId++
            val (firstName, lastName) = Utils.parseFullName(fullname)
            return User(id = "$lastId", firstName = firstName, lastName = lastName)
        }
    }

    class Builder {
        var id: String = ""
            private set

        var firstName: String? = null
            private set

        var lastName: String? = null
            private set

        var avatar: String? = null
            private set

        var rating: Int = 0
            private set

        var lastVisit: Date? = null
            private set

        var isOnline: Boolean = false
            private set

        fun id(id: String) = apply { this.id = id }
        fun firstName(firstName: String) = apply { this.firstName = firstName }
        fun lastName(lastName: String) = apply { this.lastName = lastName }
        fun avatar(avatar: String) = apply { this.avatar = avatar }
        fun rating(rating: Int) = apply { this.rating = rating }
        fun lastVisit(lastVisit: Date) = apply { this.lastVisit = lastVisit }
        fun isOnline(isOnline: Boolean) = apply { this.isOnline = isOnline }

        fun build() = User(this)
    }
}