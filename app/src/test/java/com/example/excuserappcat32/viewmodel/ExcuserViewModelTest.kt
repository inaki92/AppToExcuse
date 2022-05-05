package com.example.excuserappcat32.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.excuserappcat32.model.ExcusesItem
import com.example.excuserappcat32.rest.ExcuseRepository
import com.example.excuserappcat32.util.UIState
import com.example.excuserappcat32.util.ViewIntentRequest
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.hamcrest.MatcherAssert.assertThat

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ExcuserViewModelTest {

    @get:Rule var rule = InstantTaskExecutorRule()

    private val testCoroutineDispatcher = UnconfinedTestDispatcher()
    private val testCoroutineScope = TestScope(testCoroutineDispatcher)

    private lateinit var target: ExcuserViewModel

    private val mockRepository = mockk<ExcuseRepository>()
    // private lateinit var mockRepo2: ExcuseRepository

//    @MockK
//    private lateinit var mockRepo3: ExcuseRepository

    @Before
    fun setUp() {
        // MockKAnnotations.init()
        // mockRepo2 = mockk()
        Dispatchers.setMain(testCoroutineDispatcher)
        target = ExcuserViewModel(mockRepository, testCoroutineDispatcher)
    }

    @After
    fun tearDown() {
        clearAllMocks()
        Dispatchers.resetMain()
    }

    // ` (this is a backtick)
    @Test
    fun `get random excuses from the server to retrieve a list when it returns success`() {
        // AAA

        // ASSIGN
        val intentView = ViewIntentRequest.GetRandomExcuse(12)
        every { mockRepository.getRandomExcuseList(intentView) } returns flowOf(
            UIState.SUCCESS(
                listOf(
                    mockk<ExcusesItem>()
                )
            )
        )
        val state = mutableListOf<UIState>()
        target.excuses.observeForever {
            state.add(it)
        }

        // ACTION
        target.getListExcuse(intentView)

        // ASSERTION
        val success = state[1] as? UIState.SUCCESS<List<ExcusesItem>>
        assertEquals(2, state.size)
        assertEquals(1, success?.response?.size)
    }
}