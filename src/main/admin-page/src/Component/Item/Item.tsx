import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from "react-router-dom";
import ReactPaginate from 'react-paginate';

interface ItemInfo{
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

    function detailAnnouncement(id:number) {
        navigate(`${id}`);
    }


    const handleSort = (column: string) => {
        if (sortingColumn === column) {
            // 정렬 순서를 'ASC'와 'DESC' 사이에서 토글
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
            // const itemList = await getItem({ sortingColumn, sortingMethod }, newPage);
            // setItem(itemList.data.elements);
            // setTotalCount(itemList.data.totalCount);
        } catch (error) {
            console.error("에러 발생:", error);
        }
    }

    const onDeleteBtnClicked = async (id:number, uploaderNo:number)=> {
        console.log(`삭제시도, id:${id}`)
        try{
            // deleteItem(id, uploaderNo);
            // const newItem:ItemInfo[] = item.filter(element=>element.itemId!==id); 
            // setItem(newItem);
        } catch(error) {
            alert(`삭제에 실패했습니다. 에러: ${error}`)
        }
    }

    useEffect(() => {
        async function fetchItems() {
            // try {
            //     const itemList = await getItem({ sortingColumn, sortingMethod }, page);
            //     setItem(itemList.data.elements);
            //     setTotalCount(itemList.data.totalCount);
            //     console.log(itemList.data);
            // } catch (error) {
            //     console.error("에러 발생:", error);
            // }
        }
        //fetchItems();
    }, [sortingColumn, sortingMethod]);

    return (
        <>
            <h1 className="text-center my-3">아이템 관리</h1>
            <table className="min-w-full bg-white border border-gray-300 my-2">
                <thead>
                    <tr className="bg-gray-200">
                        <th
                            className="py-2 px-4 border-b border-gray-300 cursor-pointer"
                            onClick={() => handleSort('itemId')}
                        >
                            번호 {sortingColumn === 'itemId' && (sortingMethod === 'ASC' ? '▲' : '▼')}
                        </th>
                        <th
                            className="py-2 px-4 border-b border-gray-300 cursor-pointer"
                            onClick={() => handleSort('itemTitle')}
                        >
                            아이템 이름 {sortingColumn === 'itemTitle' && (sortingMethod === 'ASC' ? '▲' : '▼')}
                        </th>
                        <th
                            className="py-2 px-4 border-b border-gray-300 cursor-pointer"
                            onClick={() => handleSort('itemTitle')}
                        >
                            아이템 유형 {/* {sortingColumn === 'itemTitle' && (sortingMethod === 'ASC' ? '▲' : '▼')} */}
                        </th>
                        <th
                            className="py-2 px-4 border-b border-gray-300 cursor-pointer"
                            onClick={() => handleSort('itemTitle')}
                        >
                            아이템 가격 {/* {sortingColumn === 'itemTitle' && (sortingMethod === 'ASC' ? '▲' : '▼')} */}
                        </th>
                        <th
                            className="py-2 px-4 border-b border-gray-300 cursor-pointer"
                            onClick={() => handleSort('uploadTime')}
                        >
                            등록 날짜 {sortingColumn === 'uploadTime' && (sortingMethod === 'ASC' ? '▲' : '▼')}
                        </th>
                        <th
                            className="py-2 px-4 border-b border-gray-300 cursor-pointer"
                        >
                            상세 사항
                        </th>
                    </tr>
                </thead>
                <tbody>

{/* 예시데이터 */}
                        {/* <tr className="hover:bg-gray-100 cursor-pointer" key={item.itemId}> */}
                        <tr className="hover:bg-gray-100 cursor-pointer">
                            <td className="py-2 px-4 border-b border-gray-300 text-center">
                                {/* 아이템 번호 */}33
                            </td>
                            <td className="py-2 px-4 border-b border-gray-300 text-center" >
                                {/* 아이템 이름 */}대왕의자
                            </td>
                            <td className="py-2 px-4 border-b border-gray-300 text-center">
                                {/* 아이템 유형 */}의자
                            </td>
                            <td className="py-2 px-4 border-b border-gray-300 text-center">
                                {/* 아이템 가격 */}10000
                            </td>
                            <td className="py-2 px-4 border-b border-gray-300 text-center">
                                {/* 업로드 시간 */}2024.9.24 10:22:33
                            </td>
                            <td className="py-2 px-4 border-b border-gray-300 text-center">
                                {/* 상세사항 */}보기
                            </td>
                            
                        </tr>
                        {/* item 목록에 대한 행 추가 예정 */}
                </tbody>
            </table>
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
                pageCount={(Math.ceil)(totalCount/3)}
                previousLabel="< prev"
                previousClassName="bg-white border rounded px-3 py-0.5"
                renderOnZeroPageCount={null}
            />
        </>
    );
};

export default Item;
