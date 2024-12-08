package org.ic.life.main.data.database.ic

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.ic.life.main.core.configs.AppConfig

@Entity(tableName = AppConfig.IC_TABLE_NAME)
data class ICEntity(
    @PrimaryKey(autoGenerate = true)
    val uuid: Int,
    val name: String,
    val address: String,
)