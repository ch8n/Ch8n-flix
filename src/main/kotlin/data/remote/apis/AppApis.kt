package data.remote.apis

object AppApis {
    val TMDB_API: String = ""
    const val BASE_URL = "https://api.themoviedb.org/3"
    const val BASE_POSTER_URL = "https://image.tmdb.org/t/p"
    val GET_TRENDING_MOVIES = "/trending/movie/week?api_key=${TMDB_API}&language=en-US"
    val GET_TRENDING_SERIES = "/trending/tv/week?api_key=${TMDB_API}&language=en-US"
    val GET_DISCOVER_MOVIES = "/discover/movie?api_key=${TMDB_API}&language=en-US"
    val GET_DISCOVER_SERIES = "/discover/tv?api_key=${TMDB_API}&language=en-US"
    val GET_NETFLIX_ORIGINAL = "/discover/tv?api_key=${TMDB_API}&language=en-US&with_networks=213"
    val GET_ACTION_MOVIES =
        "/discover/movie?api_key=${TMDB_API}&language=en-US&sort_by=popularity.desc&include_adult=true&include_video=true&page=1&with_genres=28"
    val GET_COMEDY_MOVIES =
        "/discover/movie?api_key=${TMDB_API}&language=en-US&sort_by=popularity.desc&include_adult=true&include_video=true&page=1&with_genres=35"
    val GET_HORROR_MOVIES =
        "/discover/movie?api_key=${TMDB_API}&language=en-US&sort_by=popularity.desc&include_adult=true&include_video=true&page=1&with_genres=27"
    val GET_ROMANTIC_MOVIES =
        "/discover/movie?api_key=${TMDB_API}&language=en-US&sort_by=popularity.desc&include_adult=true&include_video=true&page=1&with_genres=10749"
    val GET_SCIFI_MOVIES =
        "/discover/movie?api_key=${TMDB_API}&language=en-US&sort_by=popularity.desc&include_adult=true&include_video=true&page=1&with_genres=878"
}