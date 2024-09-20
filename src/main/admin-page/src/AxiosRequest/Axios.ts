import axios from "axios";

const API_URL = "http://localhost:8080";

const request = axios.create({
    baseURL: API_URL
});

request.interceptors.request.use(
    config => {
        return config;
    },
    error => {
        console.error(error);
        return Promise.reject(error);
    }
);

request.interceptors.response.use(
    response => {
        return response.data;
    },
    error => {
        console.error(error);
        return Promise.reject(error);
    }
);

export const LoginAxios = (loginData: { id: string, password: string }) => {
    console.log("Sending login data:", loginData);
    return request({
        method: 'post',
        url: '/api/login',
        headers: { 'Content-Type': 'application/json' },
        data: loginData,
        withCredentials: true
    });
};

export const getAnnouncement = async ( params:undefined|null|{sortingColumn:string, sortingMethod: 'ASC' | 'DESC'}, page:number=1) => {
    const response = await axios.get('http://localhost:8000/announcement', {
        params: {
            pageNum:page,
            orderCriteria: params?.sortingColumn,
            orderMethod: params?.sortingMethod,
        },
        headers: { 'Content-Type': 'application/json' }
    });

    return response;
};

export const getAnnouncementById = async (announcementId:number) => {
    const response = await axios.get(`http://localhost:8000/announcement/${announcementId}`, {
        headers: { 'Content-Type': 'application/json' }
    });

    return response;
};