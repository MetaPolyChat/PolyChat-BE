import { Routes, Route } from "react-router-dom";
import { Login } from "./Component/Login";
import Layout from "./Component/Layout";
import HomePage from "./Component/HomePage";
import AccountPage from "./Component/AccoutPage";
import Announcement from "./Component/Annoucement";
import AnnouncementAdd from "./Component/AnnouncementAdd";

export const Routers = () => {
    return (
        <Routes>
            <Route path="/" element={<Login />} /> {/* 기본 페이지를 Login으로 설정 */}
            <Route element={<Layout />}>
                <Route path="/home" element={<HomePage />} /> {/* 메인 페이지 */}
                <Route path="/account" element={<AccountPage />} />
                <Route path="/announcement">
                    <Route index element={<Announcement/>}/>
                    <Route path="add" element={<AnnouncementAdd/>}/>
                </Route>
            </Route>
        </Routes>
    );
};
