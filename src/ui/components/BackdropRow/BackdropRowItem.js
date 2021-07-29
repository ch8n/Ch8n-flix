import { useState, useEffect } from "react";
import axios from "../../../data/remote/httpClient/httpClient";
import api from "../../../data/remote/api/request";
import "./BackdropRowItem.css";

export default function RowItem({ title, url }) {
    const [movies, setMovies] = useState([]);
    useEffect(() => {
        (async () => {
            console.log(url);
            const response = await axios.get(url)
            setMovies(response.data.results)
        })();
    }, [url])

    return (
        <div className="backdrop__row">
            <h2>{title}</h2>
            <div className="backdrop__row__list">
                {
                    movies.map(movie => {
                        return <img key={movie.id} src={`${api.base_image_url}/w500/${movie.backdrop_path}`} alt={movie.name} />
                    })
                }
            </div>
        </div>
    )
}
