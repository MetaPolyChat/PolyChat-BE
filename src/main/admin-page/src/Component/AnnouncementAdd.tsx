// HomePage.tsx
import React from "react";
import { getAnnouncement } from "../AxiosRequest/Axios";
import {useState, useEffect} from 'react';
import { Link } from "react-router-dom";

// interface AnnouncementInfo {
//     announcementId: number;
//     announcementTitle: string;
//     announcementContent: string;
//     uploaderName: string;
//     uploaderNo: number;
//     uploadTime: string;
//     lastUpdatedTime:string;
// }

const AnnouncementAdd: React.FC = () => {
    return (
            <>
                <h2>공지사항 추가</h2>
                <form className="min-w-80 w-3/5 flex flex-col py-2" method="post" action="http://localhost:8000/announcement">
                    <label>제목</label>
                    <input className="rounded-md border my-2" name="title" type="text"/>
                    <label>보내는 사람 id</label>
                    <input className="rounded-md border my-2" name=" uploaderNo" type="text"/>
                    <label>내용</label>
                    <input className="rounded-md border h-48 " name="content" type="text"/>
                    <button className="bg-sky-500 rounded-md border w-1/2 self-center my-2">제출</button>
                </form>
                <Link to="/announcement">공지사항 목록</Link>
            </>
        );

        

};

export default AnnouncementAdd;
