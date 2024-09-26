import React, { useState, useEffect } from 'react';
import { deleteAnnouncement, getAnnouncement } from "../AxiosRequest/AnnouncementApi";
import { Link, useNavigate } from "react-router-dom";
import ReactPaginate from 'react-paginate';

interface AnnouncementInfo {
    announcementId: number;
    announcementTitle: string;
    announcementContent: string;
    uploaderName: string;
    uploaderNo: number;
    uploadTime: string;
    lastUpdatedTime: string;
}

const Announcement: React.FC = () => {
    const [announcement, setAnnouncement] = useState<AnnouncementInfo[]>([]);
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
            const announcementList = await getAnnouncement({ sortingColumn, sortingMethod }, newPage);
            setAnnouncement(announcementList.data.elements);
            setTotalCount(announcementList.data.totalCount);
        } catch (error) {
            console.error("에러 발생:", error);
        }
    }

    const onDeleteBtnClicked = async (id:number, uploaderNo:number)=> {
        console.log(`삭제시도, id:${id}`)
        try{
            deleteAnnouncement(id, uploaderNo);
            const newAnnouncement:AnnouncementInfo[] = announcement.filter(item=>item.announcementId!==id); 
            setAnnouncement(newAnnouncement);
        } catch(error) {
            alert(`삭제에 실패했습니다. 에러: ${error}`)
        }

        
    }

    useEffect(() => {
        async function fetchAnnouncements() {
            try {
                const announcementList = await getAnnouncement({ sortingColumn, sortingMethod }, page);
                setAnnouncement(announcementList.data.elements);
                setTotalCount(announcementList.data.totalCount);
                console.log(announcementList.data);
            } catch (error) {
                console.error("에러 발생:", error);
            }
        }
        fetchAnnouncements();
    }, [sortingColumn, sortingMethod]);

    return (
        <>
            <h1 className="text-center my-3">공지사항</h1>
            <table className="min-w-full bg-white border border-gray-300 my-2">
                <thead>
                    <tr className="bg-gray-200">
                        <th
                            className="py-2 px-4 border-b border-gray-300 cursor-pointer"
                            onClick={() => handleSort('announcementId')}
                        >
                            번호 {sortingColumn === 'announcementId' && (sortingMethod === 'ASC' ? '▲' : '▼')}
                        </th>
                        <th
                            className="py-2 px-4 border-b border-gray-300 cursor-pointer"
                            onClick={() => handleSort('announcementTitle')}
                        >
                            제목 {sortingColumn === 'announcementTitle' && (sortingMethod === 'ASC' ? '▲' : '▼')}
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
                            관리
                        </th>
                    </tr>
                </thead>
                <tbody>
                    {announcement.map((item: AnnouncementInfo) => (
                        <tr className="hover:bg-gray-100 cursor-pointer" key={item.announcementId}>
                            <td className="py-2 px-4 border-b border-gray-300 text-center" onClick={()=>detailAnnouncement(item.announcementId)}>
                                {item.announcementId}
                            </td>
                            <td className="py-2 px-4 border-b border-gray-300" onClick={()=>detailAnnouncement(item.announcementId)}>
                                {item.announcementTitle}
                            </td>
                            <td className="py-2 px-4 border-b border-gray-300 text-center" onClick={()=>detailAnnouncement(item.announcementId)}>
                                {item.uploadTime}
                            </td>
                            <td className="py-2 px-4 border-b border-gray-300 text-center">
                                <button className="border px-2 round-10" onClick={()=>onDeleteBtnClicked(item.announcementId, item.uploaderNo)}>삭제</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <div>
                <Link to="add">공지사항 추가하기</Link>
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

export default Announcement;
