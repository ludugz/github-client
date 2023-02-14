package ludugz.simplegithubclient.presentation.route

sealed class ScreenRoute(val route: String) {
    object UserListScreen : ScreenRoute("User List Screen")
    object UserDetailScreen : ScreenRoute("User Detail Screen")
}
