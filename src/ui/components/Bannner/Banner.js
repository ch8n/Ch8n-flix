import { useState, useEffect } from "react";
import utils from "../../../data/utils/utils";
import axios from "../../../data/remote/httpClient/httpClient";
import api from "../../../data/remote/api/request";
import "./Banner.css"

export default function Banner() {

    const [bannerMovie, setBannerMovie] = useState([]);

    useEffect(() => {
        (async () => {
            const response = await axios.get(api.NetflixOriginal);
            const movies = response.data.results;
            const randomIndex = Math.floor(Math.random() * movies.length - 1);
            const randomMovie = movies[randomIndex];
            console.log(randomMovie);
            setBannerMovie(randomMovie);
        })();
    }, [])

    return (
        <header className="banner" style={{
            backgroundSize: "cover",
            backgroundImage: `url(
                "${api.base_image_url}/original/${bannerMovie.backdrop_path}"
            )`,
            backgroundPosition: "center center",
        }}>
            <div className="banner__content">
                <h1 className="banner__title">{bannerMovie?.name || bannerMovie?.title || bannerMovie?.original_name}</h1>
                <div className="button__container">
                    <button className="button_play">Play</button>
                    <button className="button_info">More Info</button>
                </div>
                <h1 className="banner__description">
                    {utils.ellipse(bannerMovie?.overview, 200)}
                </h1>
            </div>
        </header>
    )
}
