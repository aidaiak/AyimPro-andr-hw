package com.aid.ayimpro_andr_hw.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Single

@Dao
interface CharacterDao {
    @Query("SELECT * FROM CharacterEntity")
    fun getAll(): LiveData<List<CharacterEntity>>

    @Query("SELECT * FROM CharacterEntity WHERE id = :id")
    fun getById(id: Long?): Single<CharacterEntity>

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insertList(characterEntity: List<CharacterEntity>)
}