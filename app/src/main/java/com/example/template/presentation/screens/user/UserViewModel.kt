package com.example.template.presentation.screens.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.template.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class UserUiState(
    val users: List<String> = emptyList()
)

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    val uiState: StateFlow<UserUiState> =
        repository.getUsers()
            .map { list -> UserUiState(list.map { it.name }) }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                UserUiState()
            )

    fun addUser(name: String) {
        viewModelScope.launch {
            repository.addUser(name)
        }
    }
}