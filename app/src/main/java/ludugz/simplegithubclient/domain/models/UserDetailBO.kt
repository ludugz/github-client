package ludugz.simplegithubclient.domain.models

data class UserDetailBO(
    val name: String,
    val url: String,
) {

    companion object {
        val DEFAULT = UserDetailBO("", "")
    }
}