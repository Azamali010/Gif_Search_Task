package com.burrowsapps.gif.search.data.api

import com.burrowsapps.gif.search.data.api.model.GifResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface GifService {

  @GET("/v1/search?key=$API_KEY&media_filter=$MEDIA_FILTER&limit=$DEFAULT_LIMIT_COUNT")
  suspend fun fetchSearchResults(
    @Query("q")
    query: String,
    @Query("pos")
    position: String?,
  ): Response<GifResponseDto>

  @GET("/v1/trending?key=$API_KEY&media_filter=$MEDIA_FILTER&limit=$DEFAULT_LIMIT_COUNT")
  suspend fun fetchTrendingResults(
    @Query("pos")
    position: String?,
  ): Response<GifResponseDto>

  companion object {
    private const val DEFAULT_LIMIT_COUNT = 15 * 3 // 3 for gridlayout, 15 per page, 50 max
    private const val API_KEY = "LIVDSRZULELA"
    private const val MEDIA_FILTER = "minimal"
  }
}
