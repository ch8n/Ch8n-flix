package data.models

external interface Poster {
    val id: Int
    val imageUrl: String
    val name: String
}

data class KPoster(
    override val id: Int,
    override val imageUrl: String,
    override val name: String
) : Poster {
    companion object {
        val fakePoster
            get() = KPoster(
                id = (1..100).random(),
                imageUrl = "https://avatars.githubusercontent.com/u/11576342?v=4",
                name = "Chetan"
            )
    }
}

data class RowCategory(
    val id: String,
    val title: String,
    val categoryFetchUrl: String
)