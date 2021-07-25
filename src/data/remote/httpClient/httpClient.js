import axios from "axios";
import { baseURL } from "../api/request";

const BASE_URL = "https://api.themoviedb.org/3"
const instance = axios.create({
    baseURL = baseURL
})

export default instance;