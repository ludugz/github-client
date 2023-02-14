package ludugz.simplegithubclient.ui.userdetail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ludugz.simplegithubclient.common.Resource
import ludugz.simplegithubclient.common.UserState
import ludugz.simplegithubclient.domain.models.UserDetailBO
import ludugz.simplegithubclient.domain.usecases.GetUserByNameUseCase
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val getUserByNameUseCase: GetUserByNameUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var userState = mutableStateOf<UserState>(UserState.DEFAULT)

    private val userName = savedStateHandle.get<String>("userName") ?: ""

    init {
        viewModelScope.launch {
            getUser(userName = userName)
        }
    }

    private suspend fun getUser(userName: String) {
        getUserByNameUseCase(userName = userName).collect { userFlow ->
            when (userFlow) {
                is Resource.Loading -> {
                    userState.value = UserState.Loading()
                }
                is Resource.Success -> {
                    userState.value = UserState.Success(user = userFlow.data ?: UserDetailBO.DEFAULT)
                }
                is Resource.Failure -> {
                    userState.value = UserState.Failure(errorMessage = userFlow.errorMessage ?: "")
                }
            }
        }
    }
}