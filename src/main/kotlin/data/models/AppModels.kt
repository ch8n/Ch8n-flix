package data.models

data class Poster(
    val backdrop_path: String?,
    val first_air_date: String?,
    val genre_ids: List<Int>?,
    val id: Int?,
    val name: String?,
    val origin_country: String?,
    val original_language: String?,
    val original_name: String?,
    val overview: String?,
    val popularity: Double?,
    val poster_path: String?,
    val vote_average: Double?,
    val vote_count: Int?,
)

data class PosterResponse(
    val results: Array<Poster>
)


data class RowCategory(
    val id: String,
    val title: String,
    val categoryFetchUrl: String
)