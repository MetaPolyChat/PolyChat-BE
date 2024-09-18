// HomePage.tsx
import React from "react";
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

const HomePage: React.FC = () => {
    return (
        <>
            <h2>홈 페이지 내용입니다</h2>
            <div className="flex flex-row">
                <div className="basis-1/4 border">01</div>
                <div className="basis-1/4 border">02</div>
                <div className="basis-1/2 border">03</div>
            </div>
            <div>
                <WeeklyVisitorsChart />
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

export default HomePage;
