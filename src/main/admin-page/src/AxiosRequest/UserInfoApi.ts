import { request } from "./Axios";
import { SearchParam } from "./SearchInterface";

export const getUser = async (searchParam:SearchParam) => {
    const response = await request.get('/admin/user/some', {
        headers: { 'Content-Type': 'application/json' },
        params:searchParam
    });

    return response;
};

export const getRecentWeekRegisterUser = async()=>{
    const response = await request.get('/admin/user/count-day', {
        headers: { 'Content-Type': 'application/json' },
        params:{range:7}
    });

    return response;
};