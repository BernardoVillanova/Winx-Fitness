import axios, { AxiosInstance } from "axios"

const clienteHttp: AxiosInstance = axios.create({
    baseURL: "http://localhost:8080/api/v1",
    headers: {
        "Content-Type": "application/json",
    },
})

export default clienteHttp