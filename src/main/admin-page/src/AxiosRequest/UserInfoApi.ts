import { request } from "./Axios";

export const getUser = async () => {
    const response = await request.get('/admin/user', {
        headers: { 'Content-Type': 'application/json' }
    });

    return response;
};
