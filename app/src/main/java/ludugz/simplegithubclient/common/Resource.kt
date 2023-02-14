package ludugz.simplegithubclient.common

sealed class Resource<T>(val data: T? = null, val errorMessage: String? = null) {
    class Loading<T>(data: T? = null) : Resource<T>(data = data)
    class Success<T>(data: T) : Resource<T>(data = data)
    class Failure<T>(errorMessage: String) : Resource<T>(errorMessage = errorMessage)
}