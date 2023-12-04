package com.example.shemajamebeli_4.dataclasses

data class MessagingItem(
    val id: Int,
    val image: Any,
    val isTyping: Boolean,
    val lastActive: String,
    val lastMessage: String,
    val lastMessageType: String,
    val owner: String,
    val unreadMessages: Int
)