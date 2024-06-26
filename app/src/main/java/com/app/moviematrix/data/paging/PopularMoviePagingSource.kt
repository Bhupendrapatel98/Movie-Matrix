package com.app.moviematrix.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.app.moviematrix.data.model.trending.Result
import com.app.moviematrix.domain.repository.MovieRepository
import javax.inject.Inject

class PopularMoviePagingSource @Inject constructor(private val repository: MovieRepository) :
    PagingSource<Int, Result>() {
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val page = params.key ?: 1
            val response = repository.getPopularMovies(page)

            if (response.results.isNotEmpty()) {
                LoadResult.Page(
                    data = response.results,
                    prevKey = if (page == 1) null else page.minus(1),
                    nextKey = if (response.results.isEmpty()) null else page.plus(1)
                )
            } else {
                LoadResult.Error(throw Exception("No Response"))
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}