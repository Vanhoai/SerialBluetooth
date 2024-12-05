package org.ic.life.main.data.database.ic

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.ic.life.main.core.configs.AppConfig
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Entity(tableName = AppConfig.IC_TABLE_NAME)
data class ICEntity @OptIn(ExperimentalUuidApi::class) constructor(
    @PrimaryKey(autoGenerate = true)
    val uuid: Uuid = Uuid.random(),
    val name: String,
    val address: String,
)