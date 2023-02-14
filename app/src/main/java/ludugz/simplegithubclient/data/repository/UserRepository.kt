package ludugz.simplegithubclient.data.repository

import ludugz.simplegithubclient.common.Resource
import ludugz.simplegithubclient.domain.models.UserDetailBO
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun getUser(userName: String): Flow<Resource<UserDetailBO>>

    suspend fun getUsersList(): Flow<Resource<List<UserDetailBO>>>
}