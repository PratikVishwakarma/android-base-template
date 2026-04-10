package com.example.template.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.template.data.local.dao.UserDao
import com.example.template.data.local.dto.UserDto

@Database(
    entities = [UserDto::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}