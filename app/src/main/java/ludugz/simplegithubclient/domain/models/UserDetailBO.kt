package ludugz.simplegithubclient.domain.models

data class UserDetailBO(
    val name: String,
    val url: String,
    val eventUrl: String,
    val avatarUrl: String,
) {

    companion object {
        val DEFAULT = UserDetailBO("", "", "", "")
    }
}