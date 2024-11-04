export interface SearchParam {
    orderCriteria: string | null;
    orderMethod: 'ASC' | 'DESC' | null;
    pageNum: number | null;
    limit: number | null;
    searchCriteria: string | null;
    searchValue: string | null;
}
