package ludugz.simplegithubclient.ui.userslist

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ludugz.simplegithubclient.common.Resource
import ludugz.simplegithubclient.common.UserListState
import ludugz.simplegithubclient.domain.usecases.GetUsersListUseCase
import javax.inject.Inject

@HiltViewModel
class UsersListViewModel @Inject constructor(
    private val getUsersListUseCase: GetUsersListUseCase
) : ViewModel() {

    var userListState = mutableStateOf<UserListState>(UserListState.DEFAULT)
        private set

    init {
        viewModelScope.launch {
            getUsers()
        }
    }

    private suspend fun getUsers() {
        getUsersListUseCase().collect { userListFlow ->
            when (userListFlow) {
                is Resource.Loading -> {
                    userListState.value = UserListState.Loading()
                }
                is Resource.Success -> {
                    userListState.value =
                        UserListState.Success(userList = userListFlow.data ?: emptyList())
                }
                is Resource.Failure -> {
                    userListState.value =
                        UserListState.Failure(errorMessage = userListFlow.errorMessage ?: "")
                }
            }
        }
    }
}