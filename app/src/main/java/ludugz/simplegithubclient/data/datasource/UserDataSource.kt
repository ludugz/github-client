package ludugz.simplegithubclient.data.datasource

import ludugz.simplegithubclient.domain.models.UserDetailBO


/**
 * Created by Tan N. Truong, on 20 August, 2023
 * Email: ludugz@gmail.com
 */
interface UserDataSource {

    suspend fun getUserList(): List<UserDetailBO>
}