package ludugz.simplegithubclient.ui.userslist.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ludugz.simplegithubclient.common.UserListState
import ludugz.simplegithubclient.presentation.route.ScreenRoute
import ludugz.simplegithubclient.ui.userslist.UsersListViewModel
import ludugz.simplegithubclient.ui.userslist.components.UserListRowComponent

@Composable
fun UserListScreen(
    navController: NavController,
    viewModel: UsersListViewModel = hiltViewModel(),
) {
    val state = viewModel.userListState.value
    val userList = state.userList

    Box(modifier = Modifier.fillMaxSize()) {
        if (state is UserListState.Success) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                items(userList) { userDetail ->
                    UserListRowComponent(user = userDetail, onItemClick = {
                        navController.navigate(ScreenRoute.UserDetailScreen.route + "/${userDetail.name}")
                    })
                }
            }
        }

        if (state is UserListState.Loading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

        if (state is UserListState.Failure) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                text = state.errorMessage,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center
            )
        }
    }
}