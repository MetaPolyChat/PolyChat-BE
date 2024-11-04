import React, { useEffect, useState } from "react";
import { getBlockUser } from "../AxiosRequest/BlockInfoApi";

interface BlockInfo {
    id: number;
    userId: number;
    blockedUserId: number;
    createdAt: string;
}


const BlockUser: React.FC = () => {
    const [blockUsers, setBlockUsers] = useState<BlockInfo[]>([]);
    const [errorMessage, setErrorMessage] = useState<null | String>(null);


    useEffect(() => {
        async function fetchBlockInfos() {
            try {
                const blockUserList = await getBlockUser();
                setBlockUsers(blockUserList.data);
            } catch (error) {
                console.error("에러 발생:", error);
                setErrorMessage("차단 유저 정보오기 오류");
            }
        }
        fetchBlockInfos();
    }, []);

    return (
        <>
            <h1 className="text-center my-3">유저간 차단 정보</h1>
            <table className="min-w-full bg-white border border-gray-300">
                <thead>
                    <tr className="bg-gray-200">
                        <th className="py-2 px-4 border-b border-gray-300">차단번호</th>
                        <th className="py-2 px-4 border-b border-gray-300">차단 유저 번호</th>
                        <th className="py-2 px-4 border-b border-gray-300">차단 대상 번호</th>
                        <th className="py-2 px-4 border-b border-gray-300">차단 날짜</th>
                    </tr>
                </thead>
                <tbody>
                    {blockUsers.map((item: BlockInfo) => (
                        <tr className="hover:bg-gray-100" key={item.id}>
                            <td className="py-2 px-4 border-b border-gray-300 text-center">
                                {item.id}
                            </td>
                            <td className="py-2 px-4 border-b border-gray-300 text-center">
                                {item.userId}
                            </td>
                            <td className="py-2 px-4 border-b border-gray-300 text-center">
                                {item.blockedUserId}
                            </td>
                            <td className="py-2 px-4 border-b border-gray-300 text-center">
                                {item.createdAt}
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
            {(errorMessage != null) && <h2 style={{ color: "red" }}>{errorMessage}</h2>}
        </>
    );


};

export default BlockUser;
