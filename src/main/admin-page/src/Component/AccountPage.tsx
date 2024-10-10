// AccountPage.tsx
import React, { useEffect, useState } from "react";
import { getUser } from "../AxiosRequest/UserInfoApi";
import ReactPaginate from "react-paginate";

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

    const loadAccountInfo = async (searchCriteria:any=null)=>{
        try{
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
    const [limit, setLimit] = useState<number>(10);

    const onPageChange = async (event: any) => {
        const newPage: number = event.selected + 1;
        console.log(`선택된 페이지: ${newPage}`)
        setCurrentPage(newPage);
        try {
            console.log("페이지 전환 시도");
            loadAccountInfo({
                pageNum :newPage,
                orderCriteria: null,
                orderMethod: null,
                limit: limit
            });
        } catch (error) {
            console.error("에러 발생:", error);
        }
    }

    useEffect(()=>{
        loadAccountInfo({
            pageNum :1,
            orderCriteria: null,
            orderMethod: null,
            limit: limit
        });
    } ,[]);

    return (
        <>
            <h1 className="text-center my-3">유저 관리</h1>
            <table className="min-w-full bg-white border border-gray-300">
                <thead>
                    <tr className="bg-gray-200">
                        <th className="py-2 px-4 border-b border-gray-300">번호</th>
                        <th className="py-2 px-4 border-b border-gray-300">이메일</th>
                        <th className="py-2 px-4 border-b border-gray-300">닉네임</th>
                        {/* <th className="py-2 px-4 border-b border-gray-300">행성 이름</th> */}
                        <th className="py-2 px-4 border-b border-gray-300">로그인 유형</th>
                        <th className="py-2 px-4 border-b border-gray-300">가입일시</th>
                        <th className="py-2 px-4 border-b border-gray-300">권한</th>
                        {/* <th className="py-2 px-4 border-b border-gray-300">최근 로그인 시간</th> */}
                        <th className="py-2 px-4 border-b border-gray-300">탈퇴여부</th>
                        <th className="py-2 px-4 border-b border-gray-300">상세보기</th>
                    </tr>
                </thead>
                <tbody>
                    {userList.map((userInfo:UserInfo)=>{ return (
                        <tr>
                            <td className="py-2 px-4 border-b border-gray-300 text-center"
                                key={userInfo.userId}>{userInfo.userId}</td>
                            <td className="py-2 px-4 border-b border-gray-300">{userInfo.email}</td>
                            <td className="py-2 px-4 border-b border-gray-300">{userInfo.userName}</td>
                            {/* <td className="py-2 px-4 border-b border-gray-300">{userInfo.planet}</td> */}
                            <td className="py-2 px-4 border-b border-gray-300">{userInfo.loginType}</td>
                            <td className="py-2 px-4 border-b border-gray-300">2024.09.23:17:00</td>
                            <td className="py-2 px-4 border-b border-gray-300">{userInfo.authority}</td>
                            <td className="py-2 px-4 border-b border-gray-300 text-center">{userInfo.status=="DEACTIVATED"? "Y" : "N"}</td>
                            <td className="py-2 px-4 border-b border-gray-300 text-center">1</td>
                        </tr>)
                    })}
                </tbody>
            </table>

            {/* 페이지네이션 */}
            <ReactPaginate
                breakLabel="..."
                nextLabel="next >"
                nextClassName="bg-white border rounded px-3 py-0.5"
                onPageChange={onPageChange}
                pageRangeDisplayed={3}
                containerClassName="flex justify-center space-x-2 align-middle my-1"
                pageClassName="bg-white border rounded size-8 text-center py-0.5"
                pageCount={(Math.ceil)(totalCount/limit)}
                previousLabel="< prev"
                previousClassName="bg-white border rounded px-3 py-0.5"
                renderOnZeroPageCount={null}
            />
        </>
    );

};

export default AccountPage;
