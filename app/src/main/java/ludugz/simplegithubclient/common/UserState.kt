package ludugz.simplegithubclient.common

import ludugz.simplegithubclient.domain.models.UserDetailBO

sealed class UserState(
    val isLoading: Boolean = false,
    val user: UserDetailBO = UserDetailBO.DEFAULT,
    val errorMessage: String = ""
) {
    class Success(user: UserDetailBO) : UserState(user = user)
    class Failure(errorMessage: String) : UserState(errorMessage = errorMessage)
    class Loading : UserState(isLoading = true)
    object DEFAULT : UserState()
}
