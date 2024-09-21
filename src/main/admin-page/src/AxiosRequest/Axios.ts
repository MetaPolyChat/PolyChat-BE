import axios from "axios";

const API_URL = "http://localhost:8000";

const request = axios.create({
    baseURL: API_URL
});

request.interceptors.request.use(
    config => {
        console.log("인터셉터를 거침");
        return config;
    },
    error => {
        console.error(error);
        return Promise.reject(error);
    }
);

request.interceptors.response.use(
    response => {
        console.log(`받아온것: ` + response);
        return response;
        //return response.data;
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

export const getAnnouncement = async (params: undefined | null | { sortingColumn: string, sortingMethod: 'ASC' | 'DESC' }, page: number = 1) => {
    const response = await request.get('/announcement', {
        params: {
            pageNum: page,
            orderCriteria: params?.sortingColumn,
            orderMethod: params?.sortingMethod,
        },
        headers: { 'Content-Type': 'application/json' }
    });

    return response;
};

export const getAnnouncementById = async (announcementId: number) => {
    const response = await request.get(`/announcement/${announcementId}`, {
        headers: { 'Content-Type': 'application/json' }
    });

    return response;
};