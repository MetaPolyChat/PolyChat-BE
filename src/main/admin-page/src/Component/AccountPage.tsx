// AccountPage.tsx
import React from "react";

const AccountPage: React.FC = () => {
    return (
        <>
            <h1 className="text-center my-3">유저 관리</h1>
            <table className="min-w-full bg-white border border-gray-300">
                <thead>
                    <tr className="bg-gray-200">
                        <th className="py-2 px-4 border-b border-gray-300">번호</th>
                        <th className="py-2 px-4 border-b border-gray-300">아이디</th>
                        <th className="py-2 px-4 border-b border-gray-300">닉네임</th>
                        <th className="py-2 px-4 border-b border-gray-300">가입일시</th>
                        <th className="py-2 px-4 border-b border-gray-300">권한</th>
                        <th className="py-2 px-4 border-b border-gray-300">최근 로그인 시간</th>
                        <th className="py-2 px-4 border-b border-gray-300">탈퇴여부</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </>
    );


};

export default AccountPage;
