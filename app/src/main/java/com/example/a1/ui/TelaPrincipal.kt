package com.example.a1.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.a1.model.AppDatabase
import com.example.a1.viewmodel.PrincipalViewModel
import com.example.a1.viewmodel.PrincipalViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaPrincipalScreen() {

    val context = LocalContext.current

    val musicDao = AppDatabase.getDatabase(context).musicDao()
    val factory = PrincipalViewModelFactory(musicDao)
    val viewModel: PrincipalViewModel = viewModel(factory = factory)

    val playlists by viewModel.playlists.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Minhas Playlists") })
        }
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ){
            if (playlists.isEmpty()) {
                Text(
                    text = "Nenhuma playlist encontrada.",
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {

                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(playlists) { playlist ->

                        Text(
                            text = playlist.nome,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                        )
                    }
                }
            }
        }
    }
}