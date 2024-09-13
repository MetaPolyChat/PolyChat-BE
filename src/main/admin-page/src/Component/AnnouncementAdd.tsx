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
                <form method="post" action="http://localhost:8000/announcement">
                    <label>제목2</label>
                    <input name="title" type="text"/>
                    <label>내용</label>
                    <input name="content" type="text"/>
                    <label>보내는 사람 id</label>
                    <input name=" uploaderId" type="text"/>
                    <button>제출</button>
                </form>
                <Link to="/announcement">공지사항 목록</Link>
            </>
        );

        

};

export default AnnouncementAdd;
