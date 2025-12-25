package com.ravi2411sharma.facerecognition.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "residents")
data class ResidentEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val email: String,
    val phone: String,
    val unit: String,
    val type: String, // "resident" or "known_visitor"
    val embedding: String, // JSON string of FloatArray
    val imagePath: String,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)