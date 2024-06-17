package com.app.moviematrix.presentation

import com.app.moviematrix.BuildConfig
import com.app.moviematrix.data.model.trending.TrendingResponse
import com.app.moviematrix.domain.usecase.TrendingUseCase
import com.app.moviematrix.utills.Resource
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
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
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

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

        // Mocking initial fetch behavior in init block
        //`when`(trendingPersonUseCase.getTrendingPerson(BuildConfig.API_KEY)).thenReturn(flowOf(Resource.loading()))

        trendingPersonViewModel = TrendingViewModel(trendingPersonUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getTrendingPerson emits loading then success`() =
        runBlocking {
            // Given
            val mockTrendingPerson = TrendingResponse(page = 1, results = emptyList(), total_pages = 1, total_results = 1)
            val expectedResource = Resource.success(mockTrendingPerson)

            // Mocking method behavior
            `when`(trendingPersonUseCase.getTrendingPerson(BuildConfig.API_KEY)).thenReturn(flowOf(expectedResource))

            // When
            trendingPersonViewModel.getTrending(BuildConfig.API_KEY)

            // Then
            val actualResource = trendingPersonViewModel.trendingPersonStateFlow.value
            assertEquals(expectedResource, actualResource)
        }

    @Test
    fun `getTrendingPerson emits loading then failure`() =
        runBlocking {
            // Given
            val errorMessage = "Failed to load data"
            val expectedResource = Resource.failed<TrendingResponse>(errorMessage)

            // Mocking method behavior
            `when`(trendingPersonUseCase.getTrendingPerson(BuildConfig.API_KEY)).thenReturn(flowOf(expectedResource))

            // When
            trendingPersonViewModel.getTrending(BuildConfig.API_KEY)

            // Then
            val actualResource = trendingPersonViewModel.trendingPersonStateFlow.value
            assertEquals(expectedResource, actualResource)
        }
}
