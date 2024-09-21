import { request } from "./Axios";

export const getAnnouncement = async (params: undefined | null | { sortingColumn: string; sortingMethod: 'ASC' | 'DESC'; }, page: number = 1) => {
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

export const addAnnouncement = async (formData: any) => {
    const response = await request.post("/announcement", {
        body: formData,
    });

    return response
}
