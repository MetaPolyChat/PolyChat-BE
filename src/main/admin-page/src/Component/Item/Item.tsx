import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from "react-router-dom";
import ReactPaginate from 'react-paginate';
import { getItemList } from '../../AxiosRequest/ItemApi';
import { Table, TableBody, TableCell, TableHeader, TableHeaderCell, TableHeaderNormalCell, TableRow } from '../Table';

interface ItemInfo {
    itemId: number;
    itemName: string;
    itemType: string;
    price: string;
    createdAt: string;
}

const Item: React.FC = () => {

    const [itemList, setItemList] = useState<ItemInfo[]>([]);

    const [sortingColumn, setSortingColumn] = useState<string | null>(null);
    const [sortingMethod, setSortingMethod] = useState<'ASC' | 'DESC' | null>(null);
    const [page, setPage] = useState<number>(1);
    const [totalCount, setTotalCount] = useState<number>(0);

    const navigate = useNavigate();

    function detailItem(id: number) {
        navigate(`${id}`);
    }


    const handleSort = (column: string) => {
        if (sortingColumn === column) {
            setSortingMethod(sortingMethod === 'ASC' ? 'DESC' : 'ASC');
        } else {
            // 새로운 정렬 열로 설정하고 정렬 순서를 'ASC'로 초기화
            setSortingColumn(column);
            setSortingMethod('ASC');
        }
    };

    const onPageChange = async (event: any) => {
        const newPage: number = event.selected + 1;
        console.log(`선택된 페이지: ${newPage}`)
        setPage(newPage);
        try {
            console.log("페이지 전환 시도");
            const itemList = await getItemList({ sortingColumn, sortingMethod }, newPage);
            setItemList(itemList.data.elements);
            setTotalCount(itemList.data.totalCount);
        } catch (error) {
            console.error("에러 발생:", error);
        }
    }

    const onDeleteBtnClicked = async (id: number, uploaderNo: number) => {
        console.log(`삭제시도, id:${id}`)
        try {
            // deleteItem(id, uploaderNo);
            // const newItem:ItemInfo[] = item.filter(element=>element.itemId!==id); 
            // setItem(newItem);
        } catch (error) {
            alert(`삭제에 실패했습니다. 에러: ${error}`)
        }
    }

    useEffect(() => {
        async function fetchItems() {
            try {
                const itemList = await getItemList({ sortingColumn, sortingMethod }, page);
                setItemList(itemList.data.elements);
                setTotalCount(itemList.data.totalCount);
                console.log(itemList.data);
            } catch (error) {
                console.error("에러 발생:", error);
            }
        }
        fetchItems();
    }, [sortingColumn, sortingMethod]);

    return (
        <>
            <h1 className="text-center my-3">아이템 관리</h1>
            <Table>
                <TableHeader>
                        <TableHeaderCell
                            columnKey="itemId"
                            sortingColumn={sortingColumn}
                            sortingMethod={sortingMethod}
                            handleSort={handleSort}
                        >번호
                        </TableHeaderCell>
                        <TableHeaderCell
                            columnKey="itemName"
                            sortingColumn={sortingColumn}
                            sortingMethod={sortingMethod}
                            handleSort={handleSort}
                        >아이템 이름
                        </TableHeaderCell>
                        <TableHeaderCell
                            columnKey="itemType"
                            sortingColumn={sortingColumn}
                            sortingMethod={sortingMethod}
                            handleSort={handleSort}
                        >아이템 유형
                        </TableHeaderCell>
                        <TableHeaderCell
                            columnKey="price"
                            sortingColumn={sortingColumn}
                            sortingMethod={sortingMethod}
                            handleSort={handleSort}
                        >아이템 가격
                        </TableHeaderCell>
                        <TableHeaderCell
                            columnKey="uploadTime"
                            sortingColumn={sortingColumn}
                            sortingMethod={sortingMethod}
                            handleSort={handleSort}
                        >등록 날짜
                        </TableHeaderCell>
                        <TableHeaderNormalCell>
                            관리
                        </TableHeaderNormalCell>
                </TableHeader>
                <tbody >
                    {/* 예시데이터 */}

                    {/* item 목록에 대한 행 추가 예정 */}
                    {itemList.map((item: ItemInfo) => (
                        <TableRow key={item.itemId}>
                            <TableCell cellKey="itemId" asLink onClick={() => detailItem(item.itemId)}>
                                {item.itemId}
                            </TableCell>
                            <TableCell cellKey="itemName" asLink onClick={() => detailItem(item.itemId)}>
                                {item.itemName}
                            </TableCell>
                            <TableCell cellKey="itemType" asLink onClick={() => detailItem(item.itemId)}>
                                {item.itemType}
                            </TableCell>
                            <TableCell cellKey="price" asLink onClick={() => detailItem(item.itemId)}>
                                {item.price}
                            </TableCell>
                            <TableCell cellKey="uploadDate" asLink onClick={() => detailItem(item.itemId)}>
                                {item.createdAt}
                            </TableCell>
                            <TableCell cellKey="detail">
                            <button className="border px-2 round-10">삭제</button>
                            </TableCell>
                        </TableRow>
                    )
                    )}
                </tbody>
            </Table>
            <div>
                <Link to="add">아이템 추가하기</Link>
            </div>
            {/* 페이지네이션 */}
            <ReactPaginate
                breakLabel="..."
                nextLabel="next >"
                nextClassName="bg-white border rounded px-3 py-0.5"
                onPageChange={onPageChange}
                pageRangeDisplayed={3}
                containerClassName="flex justify-center space-x-2 align-middle my-1"
                pageClassName="bg-white border rounded size-8 text-center py-0.5"
                pageCount={(Math.ceil)(totalCount / 3)}
                previousLabel="< prev"
                previousClassName="bg-white border rounded px-3 py-0.5"
                renderOnZeroPageCount={null}
            />
        </>
    );
};

export default Item;
