import { Routes, Route } from "react-router-dom";
import { Login } from "./Component/Login";
import Layout from "./Component/Layout";
import HomePage from "./Component/HomePage";
import AccountPage from "./Component/AccountPage";
import Announcement from "./Component/Annoucement";
import AnnouncementAdd from "./Component/Announcement/AnnouncementAdd";
import AnnouncementDetail from "./Component/Announcement/AnnouncementDetail";
import WithdrawUser from "./Component/WithdrawUser";
import BlockUser from "./Component/BlockUser";
import UserDetail from "./Component/UserDetail";
import Item from "./Component/Item/Item";
import AddItem from "./Component/Item/ItemAdd";
import ItemDetailPage from "./Component/Item/ItemDetail";

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
                    <Route path=":announcementId" element={<AnnouncementDetail/>}/>
                </Route>
                <Route path="/item">
                    <Route index element={<Item/>}/>
                    <Route path="add" element={<AddItem/>}/>
                    <Route path=":itemId" element={<ItemDetailPage/>}/>

                </Route>
                <Route path="/userInfo" element={<UserDetail nickname={""} email={""} loginMethod={""} planetNumber={""} isAdmin={false} isWithdrawn={false} isSuspended={false} isDeactivated={false}/>}/>
                <Route path="/blockUser" element={<BlockUser/>}/>
                {/* <Route path="/inquiries" element=  */}
                <Route path="/withdrawUser" element={<WithdrawUser/>}/>
            </Route>
        </Routes>
    );
};
