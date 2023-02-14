package ludugz.simplegithubclient.domain.usecases

import kotlinx.coroutines.flow.Flow
import ludugz.simplegithubclient.common.Resource
import ludugz.simplegithubclient.data.repository.UserRepository
import ludugz.simplegithubclient.domain.models.UserDetailBO
import javax.inject.Inject

class GetUsersListUseCase @Inject constructor(
    private val usersListRepository: UserRepository
) {

    suspend operator fun invoke(): Flow<Resource<List<UserDetailBO>>> = usersListRepository.getUsersList()
}