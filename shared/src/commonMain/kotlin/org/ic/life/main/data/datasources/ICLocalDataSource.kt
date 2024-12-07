package org.ic.life.main.data.datasources

import org.ic.life.main.data.database.ic.ICEntity

interface ICLocalDataSource {
    suspend fun addIC(icEntity: ICEntity): Boolean
    suspend fun removeIC(icEntity: ICEntity): Boolean
}