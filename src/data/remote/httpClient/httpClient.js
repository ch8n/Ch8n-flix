import axios from "axios";
import api from "../api/request";

const instance = axios.create({
    baseURL : api.base_url,
    

})

export default instance;