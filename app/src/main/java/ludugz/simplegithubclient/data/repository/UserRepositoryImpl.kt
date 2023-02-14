package ludugz.simplegithubclient.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ludugz.simplegithubclient.common.Resource
import ludugz.simplegithubclient.data.remote.dto.toBO
import ludugz.simplegithubclient.domain.models.UserDetailBO
import retrofit2.HttpException
import java.io.IOException

class UserRepositoryImpl(private val api: ClientApi) : UserRepository {
    override suspend fun getUser(userName: String): Flow<Resource<UserDetailBO>> = flow {
        try {
            emit(Resource.Loading())
            val usersBO = api.getUserByName(userName = userName).toBO()
            emit(Resource.Success(usersBO))
        } catch (exception: HttpException) {
            emit(
                Resource.Failure(
                    exception.localizedMessage ?: "Sorry there is something wrong with server!"
                )
            )
        } catch (exception: IOException) {
            emit(Resource.Failure("Couldn't reach server"))
        }
    }

    override suspend fun getUsersList(): Flow<Resource<List<UserDetailBO>>> = flow {
        try {
            emit(Resource.Loading())
            val usersBO = api.getUsers().map { it.toBO() }
            emit(Resource.Success(usersBO))
        } catch (exception: HttpException) {
            emit(
                Resource.Failure(
                    exception.localizedMessage ?: "Sorry there is something wrong with server!"
                )
            )
        } catch (exception: IOException) {
            emit(Resource.Failure("Couldn't reach server"))
        }
    }
}