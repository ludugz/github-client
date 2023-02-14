package ludugz.simplegithubclient.data.repository

import ludugz.simplegithubclient.data.remote.dto.UserDetailDTO
import ludugz.simplegithubclient.data.remote.dto.UsersListDTO
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ClientApi {
    @Headers(
        "X-GitHub-Api-Version: 2022-11-28",
        "accept: application/vnd.github+json"
    )
    @GET("/users")
    suspend fun getUsers(): UsersListDTO

    @Headers(
        "X-GitHub-Api-Version: 2022-11-28",
        "accept: application/vnd.github+json"
    )
    @GET("/users/{username}")
    suspend fun getUserByName(@Path("username") userName: String): UserDetailDTO
}