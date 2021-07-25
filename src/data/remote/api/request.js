const TMDB_API = process.env.REACT_APP_TMDB_API;

export default {
    baseUrl: `"https://api.themoviedb.org/3"`,
    trendingMovies: `/trending/movie/week?api_key=${TMDB_API}&language=en-US`,
    trendingSeries: `/trending/tv/week?api_key=${TMDB_API}&language=en-US`,
    discoverMovies: `/discover/movie?api_key=${TMDB_API}&language=en-US`,
    discoverSeries: `/discover/tv?api_key=${TMDB_API}&language=en-US`,
    NetflixOriginal: `/discover/tv?api_key=${TMDB_API}&language=en-US&with_networks=213`,
    actionMovies: `/discover/movie?api_key=${TMDB_API}&language=en-US&sort_by=popularity.desc&include_adult=true&include_video=true&page=1&with_genres=28`,
    comedyMovies: `/discover/movie?api_key=${TMDB_API}&language=en-US&sort_by=popularity.desc&include_adult=true&include_video=true&page=1&with_genres=35`,
    horrorMovies: `/discover/movie?api_key=${TMDB_API}&language=en-US&sort_by=popularity.desc&include_adult=true&include_video=true&page=1&with_genres=27`,
    romanceMovies: `/discover/movie?api_key=${TMDB_API}&language=en-US&sort_by=popularity.desc&include_adult=true&include_video=true&page=1&with_genres=10749`,
    sciFiMovies: `/discover/movie?api_key=${TMDB_API}&language=en-US&sort_by=popularity.desc&include_adult=true&include_video=true&page=1&with_genres=878`,
}