package com.example.template.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.template.data.local.dto.UserDto
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserDto)

    @Query("SELECT * FROM users")
    fun getUsers(): Flow<List<UserDto>>
}