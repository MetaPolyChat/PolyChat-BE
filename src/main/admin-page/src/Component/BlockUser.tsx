import React from "react";

const BlockUser: React.FC = () => {
    return (
        <>
            <h1 className="text-center my-3">정지된 회원 목록 조회</h1>
            <table className="min-w-full bg-white border border-gray-300">
                <thead>
                    <tr className="bg-gray-200">
                        <th className="py-2 px-4 border-b border-gray-300">번호</th>
                        <th className="py-2 px-4 border-b border-gray-300">닉네임</th>
                        <th className="py-2 px-4 border-b border-gray-300">가입일시</th>
                        <th className="py-2 px-4 border-b border-gray-300">차단 누적횟수</th>
                        <th className="py-2 px-4 border-b border-gray-300">신고자</th>
                        <th className="py-2 px-4 border-b border-gray-300">상세정보</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </>
    );


};

export default BlockUser;
