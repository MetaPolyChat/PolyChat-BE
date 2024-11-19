// HomePage.tsx
import React, { useEffect, useState } from "react";
import {
    LineChart,
    Line,
    XAxis,
    YAxis,
    CartesianGrid,
    Tooltip,
    Legend,
    ResponsiveContainer,
} from 'recharts';
import { getRecentWeekRegisterUser } from "../AxiosRequest/UserInfoApi";
import { Link } from "react-router-dom";

const HomePage: React.FC = () => {


    const [registUserMap, setRegistUserMap] = useState<Map<String,number>|undefined>();

    const getRegisterUserInfo = async () => {
        try {
            const registerData: any = await getRecentWeekRegisterUser();
            console.log(registerData.data);
    
            const resultMap = new Map();
    
            // 현재 날짜부터 7일 전까지의 날짜 초기화
            const today = new Date();
            for (let i = 6; i >= 0; i--) {
                const date = new Date(today);
                date.setDate(today.getDate() - i);
    
                const dateString = date.toISOString().split('T')[0];
                resultMap.set(dateString, 0);  // 초기값으로 count 0 설정
            }
    
            // 받은 데이터로 count 값 업데이트
            registerData.data.response.forEach((item: { date?: number[]; registerCount?: number; }) => {
                console.log(`순회 아이템: ${item.date} ${item.registerCount}`)
                if (Array.isArray(item.date)) {  // DATE가 배열인 경우
                    const [year, month, day] = item.date;
                    const date = `${year}-${String(month).padStart(2, '0')}-${String(day).padStart(2, '0')}`; // YYYY-MM-DD 형식으로 변환
                    const count = item.registerCount ?? 0;
                    resultMap.set(date, count);
                }
            });
            
            setRegistUserMap(resultMap);
            //console.log(resultMap);  // 최종 resultMap 출력
        } catch (error) {
            console.error("에러 발생함", error);
        }
    };
    
    useEffect(() => {
        getRegisterUserInfo();
    }, []);
    
    //const registerData = await getRecentWeekRegisterUser();  // .data 제거

  //  console.log(resultMap);
    console.log(registUserMap);

    return (
        <>
            <h2>홈 페이지 내용입니다</h2>
            <div className="container mx-auto px-4 py-8">
    <h2 className="text-xl font-bold mb-4">홈 페이지</h2>
    
    {/* 가입자 수 그래프와 일자별 요약 표 */}
    <div className="grid grid-cols-1 md:grid-cols-5 gap-4 mb-6">
        <div className="md:col-span-3 border p-4 bg-white rounded-lg shadow-lg">
            <h3 className="text-lg font-semibold mb-4">가입자 수 그래프</h3>
            <WeeklyVisitorsChart userRegistMap={registUserMap} />
        </div>
        
        <div className="md:col-span-2 border p-4 bg-white rounded-lg shadow-lg">
            <h3 className="text-lg font-semibold mb-4">일자별 요약</h3>
            <WeeklyVisitorsTable userRegistMap={registUserMap} />
        </div>
    </div>

    {/* 공지사항과 친구모집 게시판 */}
    <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
        <div className="border p-4 bg-white rounded-lg shadow-lg">
            <h3 className="text-lg font-semibold mb-4">공지사항</h3>
            <ul>
                <li><Link to="/announcement/1">공지사항 1</Link></li>
                <li><Link to="/announcement/2">공지사항 2</Link></li>
                <li><Link to="/announcement/3">공지사항 3</Link></li>
                <li><Link to="/announcement/4">공지사항 4</Link></li>
                <li><Link to="/announcement/5">공지사항 5</Link></li>
            </ul>
            <Link to="/announcement" className="text-blue-500 hover:underline">더보기</Link>
        </div>

        <div className="border p-4 bg-white rounded-lg shadow-lg">
            <h3 className="text-lg font-semibold mb-4">친구모집 게시판</h3>
            <ul>
                <li><Link to="/friend-post/1">친구모집 1</Link></li>
                <li><Link to="/friend-post/2">친구모집 2</Link></li>
                <li><Link to="/friend-post/3">친구모집 3</Link></li>
                <li><Link to="/friend-post/4">친구모집 4</Link></li>
                <li><Link to="/friend-post/5">친구모집 5</Link></li>
            </ul>
            <Link to="/friend-post" className="text-blue-500 hover:underline">더보기</Link>
        </div>
    </div>
</div>
        </>
    );
};



// 방문자 데이터 (일주일간)
const data = [
    { day: '월요일', visitors: 35 },
    { day: '화요일', visitors: 50 },
    { day: '수요일', visitors: 45 },
    { day: '목요일', visitors: 60 },
    { day: '금요일', visitors: 38 },
    { day: '토요일', visitors: 55 },
    { day: '일요일', visitors: 40 },
];


const WeeklyVisitorsChart: React.FC<{ userRegistMap: Map<String, number> | undefined }> = ({ userRegistMap }) => {
    const data = userRegistMap
        ? Array.from(userRegistMap, ([day, visitors]) => ({ day, visitors }))
        : [];

    return (
        <ResponsiveContainer width="100%" height={300}>
            <LineChart data={data}>
                <CartesianGrid strokeDasharray="3 3" />
                <XAxis dataKey="day" />
                <YAxis allowDecimals={false} /> {/* 세로축을 정수로만 표시 */}
                <Tooltip />
                <Legend />
                <Line type="monotone" dataKey="visitors" stroke="#8884d8" activeDot={{ r: 8 }} />
            </LineChart>
        </ResponsiveContainer>
    );
};


const WeeklyVisitorsTable: React.FC<{ userRegistMap: Map<String, number> |undefined}> = ({ userRegistMap }) => {
    return (
        <>
            <table>
                <thead>
                <tr>
                    <th>일자</th>
                    <th>가입자 수</th>
                </tr>
                </thead>
                <tbody>
            
                {
    userRegistMap && Array.from(userRegistMap.entries()).map(([key, value]) => (
        <tr key={String(key)}>
            <th>{key}</th>
            <th>{value}</th>
        </tr>
    ))
}
                {/* {data.map(dayInfo => (
                    <tr key={dayInfo.day}>
                        <th>{dayInfo.day}</th>
                        <th>{dayInfo.visitors}</th>
                    </tr>
                ))} */}
                </tbody>
            </table>
        </>
    );
}

export default HomePage;