package com.example.a1.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a1.model.dao.MusicDao
import com.example.a1.model.entity.Playlist
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PrincipalViewModel(private val musicDao: MusicDao) : ViewModel() {

    private val _playlists = MutableStateFlow<List<Playlist>>(emptyList())

    val playlists: StateFlow<List<Playlist>> = _playlists.asStateFlow()

    val playlist: StateFlow<List<Playlist>> = _playlists.asStateFlow()

    init {

        viewModelScope.launch {
            musicDao.getAllPlaylists().collectLatest { listaNova ->

                _playlists.value = listaNova
            }
        }
    }
}