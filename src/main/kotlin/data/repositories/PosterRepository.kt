package data.repositories

import data.models.KPoster
import data.models.RowCategory

class PosterRepository {

    fun getCategories(): MutableList<RowCategory> {
        return mutableListOf<RowCategory>(
            RowCategory(id = "1", title = "Netflix Originals", getPosters()),
            RowCategory(id = "2", title = "Trending Movies", getPosters()),
            RowCategory(id = "3", title = "Trending Series", getPosters()),
            RowCategory(id = "4", title = "Horror", getPosters()),
            RowCategory(id = "5", title = "Action", getPosters()),
            RowCategory(id = "6", title = "Comedy", getPosters()),
            RowCategory(id = "7", title = "Romance", getPosters()),
            RowCategory(id = "8", title = "Sci-fi", getPosters()),
            RowCategory(id = "9", title = "Discover Movies", getPosters()),
            RowCategory(id = "10", title = "Discover Series", getPosters()),
        )
    }

    fun getPosters(): List<KPoster> {
        val posters = mutableListOf<KPoster>()
        repeat(20) { posters.add(KPoster.fakePoster) }
        return posters
    }
}