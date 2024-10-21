// AccountPage.tsx
import React, { useEffect, useState } from "react";
import { getUser } from "../AxiosRequest/UserInfoApi";
import ReactPaginate from "react-paginate";
import { Table, TableHeader, TableHeaderCell, TableHeaderNormalCell } from "./Table";

interface UserInfo {
    userId: number;
    email: string;
    userName: string;
    planet: string;
    loginType: string;
    authority: string;
    status: string;
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
    const [currentPage, setCurrentPage] = useState<number>(1);
    const [sortingColumn, setSortingColumn] = useState<string | null>(null);
    const [sortingMethod, setSortingMethod] = useState<'ASC' | 'DESC' | null>(null);

    const [limit, setLimit] = useState<number>(10);

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
        setCurrentPage(newPage);
        try {
            loadAccountInfo({
                pageNum: newPage,
                orderCriteria: sortingColumn,
                orderMethod: sortingMethod,
                limit: limit
            });
        } catch (error) {
            console.error("에러 발생:", error);
        }
    }

    useEffect(() => {
        loadAccountInfo({
            pageNum: 1,
            orderCriteria: sortingColumn,
            orderMethod: sortingMethod,
            limit: limit
        });
    }, [sortingColumn, sortingMethod]);

    return (
        <>
            <h1 className="text-center my-3">유저 관리</h1>
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
                                <td className="py-2 px-4 border-b border-gray-300">2024.09.23:17:00</td>
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
