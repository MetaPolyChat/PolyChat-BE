import { useState } from "react";

interface UserDetailProps {
    nickname: string;
    email: string;
    loginMethod: string;
    planetNumber: string;
    isAdmin: boolean;
    isWithdrawn: boolean;
    isSuspended: boolean;
    isDeactivated: boolean;
}

export default function Component({
    nickname = "홍길동",
    email = "hong@example.com",
    loginMethod = "이메일",
    planetNumber = "ABCD1234",
    isAdmin = false,
    isWithdrawn = false,
    isSuspended = false,
    isDeactivated = false,
}: UserDetailProps) {
    const [role, setRole] = useState(isAdmin ? "admin" : "user");
    const [deactivated, setDeactivated] = useState(isDeactivated);

    const handleSave = () => {
        console.log("저장된 정보:", { role, deactivated });
    };

    return (
        <div className="max-w-2xl mx-auto bg-white shadow-lg rounded-lg overflow-hidden">
            <div className="bg-gray-50 border-b border-gray-200 p-4">
                <h2 className="text-2xl font-bold text-gray-800">사용자 세부 정보</h2>
            </div>
            <div className="p-6 space-y-6">
                <div className="flex flex-col sm:flex-row items-center space-y-4 sm:space-y-0 sm:space-x-4">
                    <div className="w-24 h-24 rounded-full border-2 border-gray-300 overflow-hidden">
                        <img src="/placeholder.svg?height=96&width=96" alt={nickname} />
                    </div>
                    <div className="text-center sm:text-left">
                        <h2 className="text-2xl font-semibold text-gray-800">{nickname}</h2>
                        <p className="text-sm text-gray-600">{email}</p>
                    </div>
                </div>

                <div className="grid grid-cols-1 sm:grid-cols-2 gap-4 text-sm">
                    <div className="flex justify-between items-center py-2 border-b border-gray-200">
                        <span className="font-medium text-gray-600">로그인 방식:</span>
                        <span className="text-gray-800">{loginMethod}</span>
                    </div>
                    <div className="flex justify-between items-center py-2 border-b border-gray-200">
                        <span className="font-medium text-gray-600">행성 번호:</span>
                        <span className="text-gray-800">{planetNumber}</span>
                    </div>
                    <div className="flex justify-between items-center py-2 border-b border-gray-200">
                        <span className="font-medium text-gray-600">탈퇴 여부:</span>
                        <span >{isWithdrawn ? "Y" : "N"}</span>
                    </div>
                    <div className="flex justify-between items-center py-2 border-b border-gray-200">
                        <span className="font-medium text-gray-600">정지 여부:</span>
                        <span>{isSuspended ? "Y" : "N"}
                        </span>
                    </div>
                </div>

                <div className="space-y-4">
                    <div>
                        <label className="text-base font-semibold text-gray-700">권한</label>
                        <div className="flex flex-col space-y-2 mt-2">
                            <label className="flex items-center space-x-2">
                                <input
                                    type="radio"
                                    name="role"
                                    value="user"
                                    checked={role === "user"}
                                    onChange={() => setRole("user")}
                                    className="form-radio text-blue-600"
                                />
                                <span className="text-sm text-gray-600">일반 사용자</span>
                            </label>
                            <label className="flex items-center space-x-2">
                                <input
                                    type="radio"
                                    name="role"
                                    value="admin"
                                    checked={role === "admin"}
                                    onChange={() => setRole("admin")}
                                    className="form-radio text-blue-600"
                                />
                                <span className="text-sm text-gray-600">관리자</span>
                            </label>
                        </div>
                    </div>
                    <div className="flex items-center space-x-2">
                        <input
                            type="checkbox"
                            checked={deactivated}
                            onChange={() => setDeactivated(!deactivated)}
                            className="form-checkbox text-blue-600"
                        />
                        <label className="text-sm text-gray-600">계정 비활성화</label>
                    </div>
                </div>
            </div>
            <div className="bg-gray-50 border-t border-gray-200 p-4">
                <button
                    onClick={handleSave}
                    className="w-full bg-blue-600 hover:bg-blue-700 text-white font-semibold py-2 px-4 rounded-md transition duration-300 ease-in-out"
                >
                    변경사항 저장
                </button>
            </div>
        </div>
    );
}