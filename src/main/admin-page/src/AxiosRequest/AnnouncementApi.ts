import Announcement from "../Component/HomePage";
import { request } from "./Axios";

interface updateAnnouncementInfo{
    uploaderId:number,
    title:string,
    content:string,
    announcementId:number
}

export const getAnnouncement = async (params: undefined | null | { sortingColumn: string|null; sortingMethod: 'ASC' | 'DESC' |null; }, page: number = 1) => {
    const response = await request.get('/announcement/page', {
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

export const updateAnnouncement = async (announcementId:number, formData: updateAnnouncementInfo) => {
    const response = await request.put(`/announcement/${announcementId}`, {
        body: formData,
    });

    return response
}

export const deleteAnnouncement = async (announcementId: number, uploaderNo:number) => {
    const response = await request.delete(`/announcement/${announcementId}`,{
        data:{
            userNo: uploaderNo
        }
    });
    return response
}
