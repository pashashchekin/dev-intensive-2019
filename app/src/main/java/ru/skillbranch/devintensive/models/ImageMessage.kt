package ru.skillbranch.devintensive.models

import java.util.*

class ImageMessage(
        id:String,
        from: User?,
        chat: Chat,
        isIncomming: Boolean = false,
        date: Date = Date(),
        var image: String?
) : BaseMessage(id, from, chat, isIncomming, date) {
    override fun formatMessage(): String = "id:$id ${from?.firstName} ${
    if (isIncomming) "получил" else "отправил"
    } изображение \"$image\""
}