package ludugz.simplegithubclient.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ludugz.simplegithubclient.common.Constants
import ludugz.simplegithubclient.data.repository.ClientApi
import ludugz.simplegithubclient.data.repository.UserRepository
import ludugz.simplegithubclient.data.repository.UserRepositoryImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): ClientApi {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ClientApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRepository(
        api: ClientApi
    ): UserRepository {
        return UserRepositoryImpl(
            api = api,
        )
    }
}