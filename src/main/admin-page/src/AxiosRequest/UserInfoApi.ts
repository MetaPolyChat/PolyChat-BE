import { request } from "./Axios";

export const getUser = async (searchCriteria = null) => {
    const response = await request.get('/admin/user/some', {
        headers: { 'Content-Type': 'application/json' },
        params:searchCriteria
    });

    return response;
};
