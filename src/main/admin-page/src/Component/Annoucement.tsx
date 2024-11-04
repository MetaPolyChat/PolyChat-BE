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
    const [limit, setLimit] = useState<number>(5);
    const [searchCriteria, setSearchCriteria] = useState<string | null>(null);
    const [searchTerm, setSearchTerm] = useState<string | null>(null);
    const [searchValue, setSearchValue] = useState<string | null>(null);


    const navigate = useNavigate();

    function detailAnnouncement(id: number) {
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
            const announcementList = await getAnnouncement({
                orderCriteria: sortingColumn,
                orderMethod: sortingMethod,
                pageNum: newPage,
                limit,
                searchCriteria: searchCriteria,
                searchValue: searchValue
            });
            setAnnouncement(announcementList.data.elements);
            setTotalCount(announcementList.data.totalCount);
        } catch (error) {
            console.error("에러 발생:", error);
        }
    }

    const onLimitChange = (e: any) => {
        let newLimit: number = e.target.value;
        setLimit(newLimit);
        //console.log(newLimit);
    }

    const onSearchCriteriaChange = (e: React.ChangeEvent<HTMLSelectElement>) => {
        const value = e.target.value === "" ? null : e.target.value;
        setSearchCriteria(value);
        console.log(`searchCriteria:${value}`);
    }

    const handleEnterKey = (event: React.KeyboardEvent<HTMLInputElement>) => {
        //console.log(event.key);
        if (event.key === 'Enter') {
            executeSearch();
        }
    };

    const executeSearch = () => {
        // 원하는 동작을 여기에 추가
        console.log('검색 실행:', searchTerm);
        setPage(1);
        setSearchValue(searchTerm);
    };

    const onDeleteBtnClicked = async (id: number, uploaderNo: number) => {
        console.log(`삭제시도, id:${id}`)
        try {
            deleteAnnouncement(id, uploaderNo);
            const newAnnouncement: AnnouncementInfo[] = announcement.filter(item => item.announcementId !== id);
            setAnnouncement(newAnnouncement);
        } catch (error) {
            alert(`삭제에 실패했습니다. 에러: ${error}`)
        }

    }

    useEffect(() => {
        async function fetchAnnouncements() {
            try {
                console.log(`searchCrit:${searchCriteria}`);
                console.log(`svv:${searchValue}`);
                const announcementList = await getAnnouncement({
                    orderCriteria: sortingColumn,
                    orderMethod: sortingMethod,
                    pageNum: page,
                    limit,
                    searchCriteria: searchCriteria,
                    searchValue: searchValue
                });
                setAnnouncement(announcementList.data.elements);
                setTotalCount(announcementList.data.totalCount);
                console.log(announcementList.data);
            } catch (error) {
                console.error("에러 발생:", error);
            }
        }
        fetchAnnouncements();
    }, [sortingColumn, sortingMethod, limit, searchValue]);

    return (
        <>
            <h1 className="text-center my-3">공지사항</h1>

            <div className="flex flex-col sm:flex-row justify-between gap-4 bg-white rounded-md">
                {/* 표시 갯수 */}
                <div className="flex items-center gap-2 sm:w-auto w-full">
                    <label htmlFor="limit" className="font-semibold">표시 갯수</label>
                    <select
                        onChange={onLimitChange}
                        value={limit}
                        id="limit"
                        className="rounded-md border p-1 h-8"
                    >
                        <option value={5}>5</option>
                        <option value={10}>10</option>
                        <option value={20}>20</option>
                        <option value={50}>50</option>
                    </select>
                </div>

                {/* 검색 입력란 */}
                <div className="flex items-center gap-2 w-full sm:w-auto justify-end">
                    <label htmlFor="searchCriteria" className="font-semibold">검색 기준</label>
                    <select
                        id="searchCriteria"
                        onChange={onSearchCriteriaChange}
                        className="rounded-md border p-1 h-8 w-full sm:w-32"
                        value={searchCriteria ?? ""}
                    >
                        <option value="">선택</option>
                        <option value="announcementTitle">제목</option>
                        <option value="uploaderName">작성자</option>
                    </select>
                    <input
                        type="text"
                        placeholder="검색어를 입력하세요"
                        onChange={(e) => setSearchTerm(e.target.value)}
                        onKeyDown={handleEnterKey}  // 엔터 키 이벤트 핸들러
                        className="rounded-md border p-1 w-full sm:w-64 h-8"
                    />
                </div>
            </div>
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
                        <th className="py-2 px-4 border-b border-gray-300 cursor-pointer"
                        >작성자</th>
                        <th
                            className="py-2 px-4 border-b border-gray-300 cursor-pointer"
                            onClick={() => handleSort('createdAt')}
                        >
                            등록 날짜 {sortingColumn === 'createdAt' && (sortingMethod === 'ASC' ? '▲' : '▼')}
                        </th>
                        <th
                            className="py-2 px-4 border-b border-gray-300 cursor-pointer"
                        >
                            관리
                        </th>
                    </tr>
                </thead>
                <tbody>
                    {announcement.map((announce: AnnouncementInfo) => (
                        <tr className="hover:bg-gray-100 cursor-pointer" key={announce.announcementId}>
                            <td className="py-2 px-4 border-b border-gray-300 text-center" onClick={() => detailAnnouncement(announce.announcementId)}>
                                {announce.announcementId}
                            </td>
                            <td className="py-2 px-4 border-b border-gray-300" onClick={() => detailAnnouncement(announce.announcementId)}>
                                {announce.announcementTitle}
                            </td>
                            <td className="py-2 px-4 border-b border-gray-300 text-center" onClick={() => detailAnnouncement(announce.announcementId)}>
                                {announce.uploaderName}
                            </td>
                            <td className="py-2 px-4 border-b border-gray-300 text-center" onClick={() => detailAnnouncement(announce.announcementId)}>
                                {announce.uploadTime}
                            </td>
                            <td className="py-2 px-4 border-b border-gray-300 text-center">
                                <button className="border px-2 round-10" onClick={() => onDeleteBtnClicked(announce.announcementId, announce.uploaderNo)}>삭제</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <div className="flex justify-end">
    <button
        type="button"
        className="px-4 py-1 bg-sky-500 hover:bg-sky-600 text-white font-semibold rounded-lg transition duration-300 ml-auto max-w-[250px] min-w-[100px] w-full sm:w-auto"
        onClick={() => window.location.href = '/announcement/add'}
    >
        추가
    </button>
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
                pageCount={(Math.ceil)(totalCount / limit)}
                previousLabel="< prev"
                previousClassName="bg-white border rounded px-3 py-0.5"
                renderOnZeroPageCount={null}
            />
        </>
    );
};

export default Announcement;
