package ludugz.simplegithubclient.domain.usecases

import kotlinx.coroutines.flow.Flow
import ludugz.simplegithubclient.common.Resource
import ludugz.simplegithubclient.data.repository.UserRepository
import ludugz.simplegithubclient.domain.models.UserDetailBO
import javax.inject.Inject

class GetUserByNameUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(userName: String): Flow<Resource<UserDetailBO>> = userRepository.getUser(userName = userName)
}