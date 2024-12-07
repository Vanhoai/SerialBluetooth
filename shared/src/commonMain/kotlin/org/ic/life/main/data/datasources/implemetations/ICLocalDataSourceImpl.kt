package org.ic.life.main.data.datasources.implemetations

import org.ic.life.main.data.database.AppDatabase
import org.ic.life.main.data.database.ic.ICEntity
import org.ic.life.main.data.datasources.ICLocalDataSource

class ICLocalDataSourceImpl (
    private val appDatabase: AppDatabase
): ICLocalDataSource {
    private val icDao = appDatabase.icDao()

    override suspend fun addIC(icEntity: ICEntity): Boolean {
        val response = icDao.insert(icEntity)
        return response > 0L
    }

    override suspend fun removeIC(icEntity: ICEntity): Boolean {
        val response = icDao.delete(icEntity)
        return response > 0
    }
}