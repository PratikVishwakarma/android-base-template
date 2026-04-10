package com.example.template.data.repository

import com.example.template.data.local.dao.UserDao
import com.example.template.data.local.dto.UserDto
import com.example.template.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : UserRepository {

    override suspend fun addUser(name: String) {
        userDao.insertUser(UserDto(name = name))
    }

    override fun getUsers(): Flow<List<UserDto>> {
        return userDao.getUsers()
    }
}