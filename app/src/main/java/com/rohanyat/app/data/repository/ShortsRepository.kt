package com.rohanyat.app.data.repository

import com.rohanyat.app.data.database.RohanyatDatabase
import com.rohanyat.app.data.model.Short
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface ShortsRepository {
    fun getAllShorts(): Flow<List<Short>>
    fun getShortById(id: Int): Flow<Short?>
    suspend fun insertShort(short: Short)
    suspend fun deleteShort(short: Short)
}

class ShortsRepositoryImpl(private val database: RohanyatDatabase) : ShortsRepository {
    override fun getAllShorts(): Flow<List<Short>> = flow {
        emit(database.shortDao().getAllShorts())
    }

    override fun getShortById(id: Int): Flow<Short?> = flow {
        emit(database.shortDao().getShortById(id))
    }

    override suspend fun insertShort(short: Short) {
        database.shortDao().insertShort(short)
    }

    override suspend fun deleteShort(short: Short) {
        database.shortDao().deleteShort(short)
    }
}
