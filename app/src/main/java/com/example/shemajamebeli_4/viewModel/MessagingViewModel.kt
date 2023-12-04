package com.example.shemajamebeli_4.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shemajamebeli_4.dataclasses.MessagingItem

class MessagingViewModel : ViewModel() {
    private val _messagingItems = MutableLiveData<List<MessagingItem>>()
    val messagingItems: LiveData<List<MessagingItem>> get() = _messagingItems

    fun setMessagingItems(items: List<MessagingItem>) {
        _messagingItems.value = items
    }
}