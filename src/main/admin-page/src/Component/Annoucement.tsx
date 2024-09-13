// HomePage.tsx
import React from "react";
import {useState, useEffect} from 'react';
import { getAnnouncement } from "../AxiosRequest/Axios";
import { Link } from "react-router-dom";

interface AnnouncementInfo {
    announcementId: number;
    announcementTitle: string;
    announcementContent: string;
    uploaderName: string;
    uploaderNo: number;
    uploadTime: string;
    lastUpdatedTime:string;
}

const Announcement: React.FC = () => {

    const [announcement, setAnnouncement] = useState([]);

    useEffect(
        ()=>{
            async function getAnnouncement3(){

                try{
                    const announcementList = await getAnnouncement();
                    setAnnouncement(announcementList.data)
                    //console.log(announcementList);
                } catch(error){
                    console.error("에러남:",error);
                }
            }

            getAnnouncement3();
            //console.log(announcement);
            //console.log(announcement);
            //console.log(announcement);
        } ,[]);

    return (
            <>
                <h2> 공지사항 내용입니다 </h2>
                <table>
                    <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>날짜</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                    announcement.map((item:AnnouncementInfo, index) => (
                        <tr key={index}>
                            <td>
                                {item.announcementId}
                            </td>
                            <td>
                                {item.announcementTitle}
                            </td>
                            <td>
                                {String(item.uploadTime).substring(0,12)}
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </table>
                <div>
            {/* Render your announcements here */}
            {/* {
            announcement.map((item, index) => (
                <div key={index}>{index}:{item["announcementTitle"]}
                <p>{item["announcementContent"]}</p>
                <span>{item["uploadTime"]}</span>
                </div> // Adjust according to your data structure
            ))} */}

                <Link to="add">공지사항 추가하기</Link>
                </div>
            </>
        );

};

export default Announcement;
