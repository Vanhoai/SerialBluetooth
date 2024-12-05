package org.ic.life.main.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import org.ic.life.main.data.database.ic.ICDao
import org.ic.life.main.data.database.ic.ICEntity
import org.ic.life.main.data.database.message.MessageDao
import org.ic.life.main.data.database.message.MessageEntity

@Database(
    entities = [MessageEntity::class, ICEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun messageDao(): MessageDao
    abstract fun icDao(): ICDao
}