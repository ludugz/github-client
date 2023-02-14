package ludugz.simplegithubclient.common

import ludugz.simplegithubclient.domain.models.UserDetailBO

sealed class UserListState(
    val isLoading: Boolean = false,
    val userList: List<UserDetailBO> = emptyList(),
    val errorMessage: String = ""
) {
    class Success(userList: List<UserDetailBO>) : UserListState(userList = userList)
    class Failure(errorMessage: String) : UserListState(errorMessage = errorMessage)
    class Loading : UserListState(isLoading = true)
    object DEFAULT : UserListState()
}
