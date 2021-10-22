package data.repositories

import data.models.RowCategory
import data.remote.api.AppApis

class PosterRepository {

    fun getCategories(): MutableList<RowCategory> {
        return mutableListOf<RowCategory>(
            RowCategory(
                id = "1",
                title = "Netflix Originals",
                categoryFetchUrl = AppApis.GET_NETFLIX_ORIGINAL,
                isStyleBackDrop = false
            ),
            RowCategory(
                id = "2",
                title = "Trending Movies",
                categoryFetchUrl = AppApis.GET_TRENDING_MOVIES,
                isStyleBackDrop = true
            ),
            RowCategory(
                id = "3",
                title = "Trending Series",
                categoryFetchUrl = AppApis.GET_TRENDING_SERIES,
                isStyleBackDrop = true
            ),
            RowCategory(
                id = "4",
                title = "Horror",
                categoryFetchUrl = AppApis.GET_HORROR_MOVIES,
                isStyleBackDrop = true
            ),
            RowCategory(
                id = "5",
                title = "Action",
                categoryFetchUrl = AppApis.GET_ACTION_MOVIES,
                isStyleBackDrop = true
            ),
            RowCategory(
                id = "6",
                title = "Comedy",
                categoryFetchUrl = AppApis.GET_COMEDY_MOVIES,
                isStyleBackDrop = true
            ),
            RowCategory(
                id = "7",
                title = "Romance",
                categoryFetchUrl = AppApis.GET_ROMANTIC_MOVIES,
                isStyleBackDrop = true
            ),
            RowCategory(
                id = "8",
                title = "Sci-fi",
                categoryFetchUrl = AppApis.GET_SCIFI_MOVIES,
                isStyleBackDrop = true
            ),
            RowCategory(
                id = "9",
                title = "Discover Movies",
                categoryFetchUrl = AppApis.GET_DISCOVER_MOVIES,
                isStyleBackDrop = true
            ),
            RowCategory(
                id = "10",
                title = "Discover Series",
                categoryFetchUrl = AppApis.GET_DISCOVER_SERIES,
                isStyleBackDrop = true
            ),
        )
    }
}