import { request } from "./Axios";

export const getBlockUser = async () => {
    const response = await request.get('/admin/blockuser', {
        headers: { 'Content-Type': 'application/json' }
    });

    return response;
};
