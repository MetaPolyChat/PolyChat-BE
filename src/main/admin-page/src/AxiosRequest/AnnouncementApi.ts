import { request } from "./Axios";

interface updateAnnouncementInfo{
    uploaderId:number|undefined,
    title:string,
    content:string,
}

interface SearchParam{
    orderCriteria:string|null,
    orderMethod:'ASC'|'DESC'|null,
    pageNum:number|null,
    limit:number|null,
    searchCriteria:string|null,
    searchValue:string|null
}


export const getAnnouncement = async (searchParam:SearchParam) => {
    const response = await request.get('/announcement/page', {
        params: searchParam
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
    const response = await request.post("/announcement", formData ,{
        headers: { 'Content-Type': 'application/json' }
    });

    return response
}

export const updateAnnouncement = async (announcementId:number, formData: updateAnnouncementInfo) => {
    console.log(`formData:${formData.uploaderId}`)
    const response = await request.put(`/announcement/${announcementId}`, formData,
        {
            headers: { 'Content-Type': 'application/json' }}
    );

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
