// AccountPage.tsx
import React, { useEffect, useState } from "react";
import { getUser } from "../AxiosRequest/UserInfoApi";
import ReactPaginate from "react-paginate";
import { Table, TableHeader, TableHeaderCell, TableHeaderNormalCell } from "./Table";
import { useNavigate } from "react-router-dom";

interface UserInfo {
    userId: number;
    email: string;
    userName: string;
    planet: string;
    loginType: string;
    authority: string;
    status: string;
    createdAt:string;
}


const AccountPage: React.FC = () => {

    const loadAccountInfo = async (searchCriteria: any = null) => {
        try {
            const userInfo = await getUser(searchCriteria);
            setUserList(userInfo.data.elements);
            setTotalCount(userInfo.data.totalCount);
        } catch (error) {
            console.error("유저 정보 로드 중 에러 발생");
        }
    }

    const [userList, setUserList] = useState<UserInfo[]>([]);
    const [totalCount, setTotalCount] = useState<number>(0);
    const [page, setPage] = useState<number>(1);
    const [sortingColumn, setSortingColumn] = useState<string | null>(null);
    const [sortingMethod, setSortingMethod] = useState<'ASC' | 'DESC' | null>(null);

    const [limit, setLimit] = useState<number>(10);
    const [searchCriteria, setSearchCriteria] = useState<string | null>(null);
    const [searchTerm, setSearchTerm] = useState<string | null>(null);
    const [searchValue, setSearchValue] = useState<string | null>(null);


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
        setPage(newPage);
        try {
            loadAccountInfo({
                pageNum: newPage,
                orderCriteria: sortingColumn,
                orderMethod: sortingMethod,
                limit,
                searchCriteria,
                searchValue
            });
        } catch (error) {
            console.error("에러 발생:", error);
        }
    }


    const onLimitChange = (e:any)=>{
        //console.log(e.target.value);
        setLimit(e.target.value);
        console.log(limit);
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


    useEffect(() => {
        loadAccountInfo({
            pageNum: 1,
            orderCriteria: sortingColumn,
            orderMethod: sortingMethod,
            limit,
            searchCriteria,
            searchValue
        });
    }, [sortingColumn, sortingMethod, limit, searchValue]);

    return (
        <>
            <h1 className="text-center my-3">유저 관리</h1>
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
                        <option value="userName">닉네임</option>
                        <option value="email">이메일</option>
                        <option value="authority">권한</option>
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
            <Table>
                <TableHeader>
                    <TableHeaderCell columnKey="userId"
                        sortingColumn={sortingColumn} sortingMethod={sortingMethod}
                        handleSort={handleSort}
                    >번호
                    </TableHeaderCell>
                    <TableHeaderCell columnKey="email"
                        sortingColumn={sortingColumn} sortingMethod={sortingMethod}
                        handleSort={handleSort}
                    >이메일
                    </TableHeaderCell>
                    <TableHeaderCell columnKey="user_name"
                        sortingColumn={sortingColumn} sortingMethod={sortingMethod}
                        handleSort={handleSort}
                    >닉네임
                    </TableHeaderCell>
                    {/* <th className="py-2 px-4 border-b border-gray-300">행성 이름</th> */}
                    <TableHeaderCell columnKey="login_type"
                        sortingColumn={sortingColumn} sortingMethod={sortingMethod}
                        handleSort={handleSort}
                    >로그인 유형
                    </TableHeaderCell>
                    <TableHeaderCell columnKey="created_at"
                        sortingColumn={sortingColumn} sortingMethod={sortingMethod}
                        handleSort={handleSort}
                    >가입일시
                    </TableHeaderCell>
                    <TableHeaderCell columnKey="authority"
                        sortingColumn={sortingColumn} sortingMethod={sortingMethod}
                        handleSort={handleSort}
                    >권한
                    </TableHeaderCell>
                    <TableHeaderNormalCell>
                        탈퇴여부
                    </TableHeaderNormalCell>
                    {/* <TableHeaderCell columnKey="status"
                        sortingColumn={sortingColumn} sortingMethod={sortingMethod}
                        handleSort={handleSort}
                    >탈퇴여부
                    </TableHeaderCell> */}
                    {/* <th className="py-2 px-4 border-b border-gray-300">최근 로그인 시간</th> */}
                    {/* <th className="py-2 px-4 border-b border-gray-300">상세보기</th> */}
                </TableHeader>
                <tbody>
                    {userList.map((userInfo: UserInfo) => {
                        return (
                            <tr key={userInfo.userId}>
                                <td className="py-2 px-4 border-b border-gray-300 text-center"
                                >{userInfo.userId}</td>
                                <td className="py-2 px-4 border-b border-gray-300">{userInfo.email}</td>
                                <td className="py-2 px-4 border-b border-gray-300">{userInfo.userName}</td>
                                {/* <td className="py-2 px-4 border-b border-gray-300">{userInfo.planet}</td> */}
                                <td className="py-2 px-4 border-b border-gray-300">{userInfo.loginType}</td>
                                <td className="py-2 px-4 border-b border-gray-300">{userInfo.createdAt}</td>
                                <td className="py-2 px-4 border-b border-gray-300">{userInfo.authority}</td>
                                <td className="py-2 px-4 border-b border-gray-300 text-center">{userInfo.status == "DEACTIVATED" ? "Y" : "N"}</td>
                                {/* <td className="py-2 px-4 border-b border-gray-300 text-center">1</td> */}
                            </tr>)
                    })}
                </tbody>
            </Table>

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

export default AccountPage;
