package data.models

external interface Poster {
    val id: String?
    val poster_path: String?
    val name: String?
    val backdrop_path: String?
    val overview: String?
}

external interface PosterResponse {
    val results: List<Poster>
}

data class KPoster(
    override val results: List<Poster>
) : PosterResponse

data class RowCategory(
    val id: String,
    val title: String,
    val categoryFetchUrl: String
)