// AccountPage.tsx
import React, { useEffect, useState } from "react";
import { getUser } from "../AxiosRequest/UserInfoApi";

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

    const [userList, setUserList] = useState<UserInfo[]>([]);

    useEffect(()=>{
        async function getUserList(){
            try{
                const userList = await getUser();
                //console.log(userList.data);
                setUserList(userList.data);
            } catch{
                console.log("에러남");
            }
        }
        
        getUserList();
        console.log("유저리스트?");
        //console.log(userList)
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
                        <th className="py-2 px-4 border-b border-gray-300">행성 이름</th>
                        <th className="py-2 px-4 border-b border-gray-300">로그인 유형</th>
                        {/* <th className="py-2 px-4 border-b border-gray-300">가입일시</th> */}
                        <th className="py-2 px-4 border-b border-gray-300">권한</th>
                        {/* <th className="py-2 px-4 border-b border-gray-300">최근 로그인 시간</th> */}
                        <th className="py-2 px-4 border-b border-gray-300">탈퇴여부</th>
                    </tr>
                </thead>
                <tbody>
                    {userList.map((userInfo:UserInfo)=>{ return (
                        <tr>
                            <td className="py-2 px-4 border-b border-gray-300 text-center">{userInfo.userId}</td>
                            <td className="py-2 px-4 border-b border-gray-300">{userInfo.email}</td>
                            <td className="py-2 px-4 border-b border-gray-300">{userInfo.userName}</td>
                            <td className="py-2 px-4 border-b border-gray-300">{userInfo.planet}</td>
                            <td className="py-2 px-4 border-b border-gray-300">{userInfo.loginType}</td>
                            <td className="py-2 px-4 border-b border-gray-300">{userInfo.authority}</td>
                            <td className="py-2 px-4 border-b border-gray-300 text-center">{userInfo.status=="DEACTIVATED"? "O" : "X"}</td>
                        </tr>)
                    })}
                </tbody>
            </table>
        </>
    );


};

export default AccountPage;
