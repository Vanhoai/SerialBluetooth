package org.ic.life.main.core.base

interface BaseUseCase<in P, out R> {
    suspend fun invoke(params: P): R = throw NotImplementedError()
}