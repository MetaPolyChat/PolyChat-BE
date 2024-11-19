
import { request } from "./Axios";
import { SearchParam } from "./SearchInterface";



export const getItemList = async (searchParam:SearchParam) => {
    const response = await request.get('/item', {
        params: searchParam,
        headers: { 'Content-Type': 'application/json' }
    });

    return response;
};

export const getItemById = async (itemId: number) => {
    const response = await request.get(`/item/${itemId}`, {
        headers: { 'Content-Type': 'application/json' }
    });

    return response;
};

export const addItem = async (formData: any) => {
    const response = await request.post("/item", {
        body: formData,
    });

    return response
}


export const deleteItem = async (itemId: number) => {
    const response = await request.delete(`/item/${itemId}`);
    return response
}
