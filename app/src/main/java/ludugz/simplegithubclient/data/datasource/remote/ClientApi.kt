package ludugz.simplegithubclient.data.datasource.remote

import ludugz.simplegithubclient.data.dto.UserDTO
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ClientApi {
    @Headers(
        "X-GitHub-Api-Version: 2022-11-28",
        "accept: application/vnd.github+json"
    )
    @GET("/users")
    suspend fun getUsers(): List<UserDTO>

    @Headers(
        "X-GitHub-Api-Version: 2022-11-28",
        "accept: application/vnd.github+json"
    )
    @GET("/users/{username}")
    suspend fun getUser(@Path("username") userName: String): UserDTO
}