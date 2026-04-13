package com.example.template.domain.repository

import com.example.template.data.local.dto.UserDto
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun addUser(name: String)
    fun getUsers(): Flow<List<UserDto>>
}