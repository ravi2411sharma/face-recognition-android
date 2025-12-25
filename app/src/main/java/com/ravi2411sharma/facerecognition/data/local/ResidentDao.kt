package com.ravi2411sharma.facerecognition.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ResidentDao {
    @Insert
    suspend fun insert(resident: ResidentEntity): Long

    @Update
    suspend fun update(resident: ResidentEntity)

    @Delete
    suspend fun delete(resident: ResidentEntity)

    @Query("SELECT * FROM residents WHERE id = :id")
    suspend fun getResidentById(id: Long): ResidentEntity?

    @Query("SELECT * FROM residents")
    fun getAllResidents(): Flow<List<ResidentEntity>>

    @Query("SELECT * FROM residents WHERE type = :type")
    fun getResidentsByType(type: String): Flow<List<ResidentEntity>>

    @Query("SELECT * FROM residents WHERE name LIKE '%' || :query || '%'")
    fun searchResidents(query: String): Flow<List<ResidentEntity>>

    @Query("SELECT COUNT(*) FROM residents")
    suspend fun getCount(): Int

    @Query("DELETE FROM residents")
    suspend fun deleteAll()

    @Query("SELECT * FROM residents ORDER BY createdAt DESC LIMIT :limit")
    fun getRecentResidents(limit: Int): Flow<List<ResidentEntity>>
}