package ludugz.simplegithubclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ludugz.simplegithubclient.presentation.route.ScreenRoute
import ludugz.simplegithubclient.ui.theme.GithubClientTheme
import ludugz.simplegithubclient.ui.userdetail.screen.UserDetailScreen
import ludugz.simplegithubclient.ui.userslist.screen.UserListScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GithubClientTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = ScreenRoute.UserListScreen.route
                    ) {
                        composable(ScreenRoute.UserListScreen.route) {
                            UserListScreen(navController = navController)
                        }
                        composable(ScreenRoute.UserDetailScreen.route + "/{userName}") {
                            UserDetailScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GithubClientTheme() {
        Greeting("Android")
    }
}