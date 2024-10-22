
import { request } from "./Axios";

export const getItemList = async (params: undefined | null | { sortingColumn: string|null; sortingMethod: 'ASC' | 'DESC'|null; }
    , page: number = 1, limit:number=5) => {
    const response = await request.get('/item', {
        params: {
            orderCriteria: params?.sortingColumn,
            orderMethod: params?.sortingMethod,
            limit: limit
        },
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
