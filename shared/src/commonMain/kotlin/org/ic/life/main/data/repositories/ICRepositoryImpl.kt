package org.ic.life.main.data.repositories

import org.ic.life.main.data.database.ic.ICDao
import org.ic.life.main.data.datasources.ICLocalDataSource
import org.ic.life.main.domain.repositories.ICRepository

class ICRepositoryImpl(
    private val icLocalDataSource: ICLocalDataSource
) : ICRepository {}