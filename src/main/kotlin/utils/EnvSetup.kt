package utils

external interface Env {
    val TMDB_API_KEY: String
}

external object process {
    val env: Env
}