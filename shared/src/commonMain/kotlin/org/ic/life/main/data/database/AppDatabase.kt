package org.ic.life.main.data.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import org.ic.life.main.data.database.ic.ICDao
import org.ic.life.main.data.database.ic.ICEntity
import org.ic.life.main.data.database.message.MessageDao
import org.ic.life.main.data.database.message.MessageEntity

@Suppress("NO_ACTUAL_FOR_EXPECT")
internal expect object AppDatabaseCtor : RoomDatabaseConstructor<AppDatabase>

@Database(
    entities = [MessageEntity::class, ICEntity::class],
    version = 1
)
@ConstructedBy(AppDatabaseCtor::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun messageDao(): MessageDao
    abstract fun icDao(): ICDao
}