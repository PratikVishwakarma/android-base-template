package com.example.template.presentation.screens.user

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UserScreen(
    viewModel: UserViewModel
) {
    val state by viewModel.uiState.collectAsState()

    var text by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter name") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            viewModel.addUser(text)
            text = ""
        }) {
            Text("Add User")
        }

        Spacer(modifier = Modifier.height(16.dp))

        state.users.forEach {
            Text(it)
        }
    }
}