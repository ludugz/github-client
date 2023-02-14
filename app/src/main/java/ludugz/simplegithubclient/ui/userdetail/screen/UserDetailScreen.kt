package ludugz.simplegithubclient.ui.userdetail.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ludugz.simplegithubclient.common.UserState
import ludugz.simplegithubclient.ui.userdetail.UserDetailViewModel

@Composable
fun UserDetailScreen(
    viewModel: UserDetailViewModel = hiltViewModel()
) {
    val userState = viewModel.userState.value
    val user = userState.user

    Box(modifier = Modifier.fillMaxSize()) {
        if (userState is UserState.Success) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "User: ",
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Text(text = user.name)
                    }

                    Spacer(modifier = Modifier.height(5.dp))
                }
            }
        }

        if (userState is UserState.Loading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

        if (userState is UserState.Failure) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                text = userState.errorMessage,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center
            )
        }
    }
}