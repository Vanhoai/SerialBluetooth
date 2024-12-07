package org.ic.life.main.data.database.message

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.ic.life.main.core.configs.AppConfig

@Entity(tableName = AppConfig.MESSAGE_TABLE_NAME)
data class MessageEntity(
    @PrimaryKey(autoGenerate = true)
    val uuid: Long,
    val message: String,
    val author: Long,
    val channel: Long,
)