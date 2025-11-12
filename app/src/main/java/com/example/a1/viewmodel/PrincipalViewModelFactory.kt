package com.example.a1.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.a1.model.dao.MusicDao

class PrincipalViewModelFactory(private val dao: MusicDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(PrincipalViewModel::class.java)) {

            @Suppress("UNCHECKED_CAST")

            return PrincipalViewModel(dao) as T
        }

        throw IllegalArgumentException("Uncknown ViewModel class")
    }
}