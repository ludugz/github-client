package ludugz.simplegithubclient.domain.usecases

import kotlinx.coroutines.runBlocking
import ludugz.simplegithubclient.data.repository.UserRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetUsersListUseCaseTest {

    private lateinit var classUnderTest: GetUsersListUseCase

    private lateinit var repository: UserRepository

    @Before
    fun setUp() {
        repository = Mockito.mock(UserRepository::class.java)
        classUnderTest = GetUsersListUseCase(repository)
    }

    @Test
    fun `test invoke`(): Unit = runBlocking {
        classUnderTest()
        Mockito.verify(repository).getUsersList()
    }
}