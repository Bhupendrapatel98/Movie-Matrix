package com.app.moviematrix.presentation

import androidx.paging.PagingData
import app.cash.turbine.test
import com.app.moviematrix.data.model.trending.Result
import com.app.moviematrix.domain.usecase.TrendingUseCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.atLeastOnce
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import kotlin.time.ExperimentalTime


@RunWith(MockitoJUnitRunner::class)
@OptIn(ExperimentalCoroutinesApi::class)
class TrendingPersonViewModelTest {

    @Mock
    private lateinit var trendingPersonUseCase: TrendingUseCase

    private lateinit var trendingPersonViewModel: TrendingViewModel

    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)

        `when`(trendingPersonUseCase.getTrendingPerson()).thenReturn(flowOf(PagingData.empty()))
        `when`(trendingPersonUseCase.getTrendingMovies()).thenReturn(flowOf(PagingData.empty()))
        `when`(trendingPersonUseCase.getTrendingTvShow()).thenReturn(flowOf(PagingData.empty()))

        val testScope = TestScope(testDispatcher)
        trendingPersonViewModel = TrendingViewModel(trendingPersonUseCase, testScope)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @OptIn(ExperimentalTime::class)
    @Test
    fun `test getTrending calls all use case methods`() = runTest {

        val personFlow = flowOf(mockResult)

        // Mock the return values for each method
        `when`(trendingPersonUseCase.getTrendingPerson()).thenReturn(personFlow)
        `when`(trendingPersonUseCase.getTrendingMovies()).thenReturn(personFlow)
        `when`(trendingPersonUseCase.getTrendingTvShow()).thenReturn(personFlow)

        // When
        trendingPersonViewModel.getTrending()

        // Advance the test dispatcher to ensure all coroutines complete
        advanceUntilIdle()

        // Then
        // Verify that each use case method was called
        verify(trendingPersonUseCase, atLeastOnce()).getTrendingPerson()
        verify(trendingPersonUseCase, atLeastOnce()).getTrendingMovies()
        verify(trendingPersonUseCase, atLeastOnce()).getTrendingTvShow()

//        assertThat(personFlow, instanceOf(Flow::class.java))
//        assertThat(trendingPersonViewModel.trendingPersonStateFlow, instanceOf(Flow::class.java))

        trendingPersonViewModel.trendingPersonStateFlow.test {
            assertEquals(mockResult, awaitItem())
        }

    }

}
