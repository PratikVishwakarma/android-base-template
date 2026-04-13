package com.example.template.data.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserDto(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String
)