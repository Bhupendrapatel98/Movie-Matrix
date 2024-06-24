package com.app.moviematrix.presentation

import androidx.paging.PagingData
import com.app.moviematrix.BuildConfig
import com.app.moviematrix.data.model.trending.Result
import com.app.moviematrix.data.model.trending.TrendingResponse
import com.app.moviematrix.domain.usecase.TrendingUseCase
import com.app.moviematrix.utills.Resource
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
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

//@RunWith(MockitoJUnitRunner::class)
//@OptIn(ExperimentalCoroutinesApi::class)
class TrendingPersonViewModelTest {
    /* @Mock
     private lateinit var trendingPersonUseCase: TrendingUseCase

     private lateinit var trendingPersonViewModel: TrendingViewModel
     //private val testDispatcher = UnconfinedTestDispatcher()
     private val testDispatcher = StandardTestDispatcher()

     @Before
     fun setUp() {
         MockitoAnnotations.openMocks(this)
         Dispatchers.setMain(testDispatcher)

         // Mocking initial fetch behavior in init block
         `when`(trendingPersonUseCase.getTrendingPerson()).thenReturn(flowOf(PagingData.empty()))
         `when`(trendingPersonUseCase.getTrendingMovies(BuildConfig.API_KEY)).thenReturn(flowOf(Resource.loading()))
         `when`(trendingPersonUseCase.getTrendingTvShow(BuildConfig.API_KEY)).thenReturn(flowOf(Resource.loading()))

         trendingPersonViewModel = TrendingViewModel(trendingPersonUseCase)
     }

     @After
     fun tearDown() {
         Dispatchers.resetMain()
     }

     @Test
     fun `getTrendingPerson emits loading then success`() = runTest {
         // Given
         val mockTrendingPersonResult = Result()
         val singleItemFlow = listOf(mockTrendingPersonResult)
         val mockTrendingPerson : PagingData<Result> = PagingData.from(singleItemFlow)
         val trendingPersonData = flowOf(mockTrendingPerson)

         val mockTrendingMovies = Resource.success(TrendingResponse(page = 1, results = emptyList(), total_pages = 1, total_results = 1))
         val mockTrendingTvShow = Resource.success(TrendingResponse(page = 1, results = emptyList(), total_pages = 1, total_results = 1))

         // Mocking method behavior
         `when`(trendingPersonUseCase.getTrendingPerson()).thenReturn(trendingPersonData)
         `when`(trendingPersonUseCase.getTrendingMovies(BuildConfig.API_KEY)).thenReturn(flowOf(mockTrendingMovies))
         `when`(trendingPersonUseCase.getTrendingTvShow(BuildConfig.API_KEY)).thenReturn(flowOf(mockTrendingTvShow))

         // When
         trendingPersonViewModel.getTrending(BuildConfig.API_KEY)


         advanceUntilIdle()
         val actualTrendingPersonData = trendingPersonViewModel.trendingPersonStateFlow.collect()
         val expectedResponse= trendingPersonData.collect()

         // Then
         assertEquals(expectedResponse, actualTrendingPersonData)
         assertEquals(mockTrendingMovies, trendingPersonViewModel.trendingMoviesStateFlow.value)
         assertEquals(mockTrendingTvShow, trendingPersonViewModel.trendingTvShowStateFlow.value)
     }

     @Test
     fun `getTrendingPerson emits loading then failure`() = runTest {
         // Given
         val errorMessage = "Failed to load data"
         val expectedResource = Resource.failed<TrendingResponse>(errorMessage)

         // Mocking method behavior
         //`when`(trendingPersonUseCase.getTrendingPerson()).thenReturn(flowOf(expectedResource))
         `when`(trendingPersonUseCase.getTrendingMovies(BuildConfig.API_KEY)).thenReturn(flowOf(expectedResource))
         `when`(trendingPersonUseCase.getTrendingTvShow(BuildConfig.API_KEY)).thenReturn(flowOf(expectedResource))

         // When
         trendingPersonViewModel.getTrending(BuildConfig.API_KEY)

         advanceUntilIdle()
         // Then
         //assertEquals(expectedResource, trendingPersonViewModel.trendingPersonStateFlow.value)
         assertEquals(expectedResource, trendingPersonViewModel.trendingMoviesStateFlow.value)
         assertEquals(expectedResource, trendingPersonViewModel.trendingTvShowStateFlow.value)
     }*/
}
