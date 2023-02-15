package ludugz.simplegithubclient.domain.usecases

import kotlinx.coroutines.runBlocking
import ludugz.simplegithubclient.data.repository.UserRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetUserByNameUseCaseTest {

    private lateinit var classUnderTest: GetUserByNameUseCase

    private lateinit var repository: UserRepository

    @Before
    fun setUp() {
        repository = Mockito.mock(UserRepository::class.java)
        classUnderTest = GetUserByNameUseCase(repository)
    }

    @Test
    fun `test invoke`(): Unit = runBlocking {
        classUnderTest(userName = "dummy user name")
        Mockito.verify(repository).getUser("dummy user name")
    }
}