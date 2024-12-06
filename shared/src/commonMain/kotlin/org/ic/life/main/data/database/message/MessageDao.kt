package org.ic.life.main.data.database.message

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import org.ic.life.main.core.configs.AppConfig

@Dao
interface MessageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(message: MessageEntity): Long

    @Update
    suspend fun update(message: MessageEntity): Int

    @Delete
    suspend fun delete(message: MessageEntity): Int

    @Query("SELECT * FROM ${AppConfig.MESSAGE_TABLE_NAME}")
    suspend fun finds(): List<MessageEntity>
}