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
            registerData.data.forEach((item: { date?: number[]; registerCount?: number; }) => {
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
            <div className="flex flex-row">
                <div className="basis-1/4 border">01</div>
                <div className="basis-1/4 border">02</div>
                <div className="basis-1/2 border">03</div>
            </div>
            테스트
            <div className="grid grid-cols-2 gap-4 border">
                <div className="border ...">01</div>
                <div className="border ...">02</div>
                <div className="border ...">03</div>
                <div className="border col-span-2 ...">04</div>
                <div className="border ...">방문자 현황 그래프
                    <WeeklyVisitorsChart />

                </div>
                <div className="border ...">일자별 요약
                    <WeeklyVisitorsTable userRegistMap={registUserMap}/>
                </div>
                <div className="border col-span-2 ...">신고 접수</div>
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


const WeeklyVisitorsChart: React.FC = () => {
    return (
        <ResponsiveContainer width="100%" height={400}>
            <LineChart data={data}>
                <CartesianGrid strokeDasharray="3 3" />
                <XAxis dataKey="day" />
                <YAxis />
                <Tooltip />
                <Legend />
                <Line type="monotone" dataKey="visitors" stroke="#8884d8" activeDot={{ r: 8 }} />
            </LineChart>
        </ResponsiveContainer>
    );
}

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
