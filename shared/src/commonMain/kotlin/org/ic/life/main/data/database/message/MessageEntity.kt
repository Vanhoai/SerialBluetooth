package org.ic.life.main.data.database.message

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.ic.life.main.core.configs.AppConfig
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Entity(tableName = AppConfig.MESSAGE_TABLE_NAME)
data class MessageEntity @OptIn(ExperimentalUuidApi::class) constructor(
    @PrimaryKey(autoGenerate = true)
    val uuid: Uuid = Uuid.random(),
    val message: String,
    val author: Uuid,
    val channel: Uuid,
)