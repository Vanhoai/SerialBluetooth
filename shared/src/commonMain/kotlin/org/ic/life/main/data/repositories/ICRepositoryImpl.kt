package org.ic.life.main.data.repositories

import org.ic.life.main.data.database.ic.ICDao
import org.ic.life.main.domain.repositories.ICRepository

class ICRepositoryImpl(
    private val icDao: ICDao
) : ICRepository {}