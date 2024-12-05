package org.ic.life.main.data.database.ic

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import org.ic.life.main.core.configs.AppConfig

@Dao
interface ICDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(ic: ICEntity)

    @Update
    suspend fun update(ic: ICEntity)

    @Delete
    suspend fun delete(ic: ICEntity)

    @Query("SELECT * FROM ${AppConfig.IC_TABLE_NAME}")
    suspend fun finds(): List<ICEntity>
}