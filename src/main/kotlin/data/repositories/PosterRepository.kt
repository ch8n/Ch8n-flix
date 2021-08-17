package data.repositories

import data.models.KPoster

class PosterRepository {

    fun getPosters(): List<KPoster> {
        val posters = mutableListOf<KPoster>()
        repeat(20) { posters.add(KPoster.fakePoster) }
        return posters
    }
}