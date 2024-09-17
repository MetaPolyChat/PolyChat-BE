// HomePage.tsx
import React from "react";
import { useState, useEffect } from 'react';
import { getAnnouncement } from "../AxiosRequest/Axios";
import { Link } from "react-router-dom";
import ReactPaginate from 'react-paginate';

interface AnnouncementInfo {
    announcementId: number;
    announcementTitle: string;
    announcementContent: string;
    uploaderName: string;
    uploaderNo: number;
    uploadTime: string;
    lastUpdatedTime: string;
}

const Announcement: React.FC = () => {

    const [announcement, setAnnouncement] = useState([]);

    useEffect(
        () => {
            async function getAnnouncement3() {

                try {
                    const announcementList = await getAnnouncement();
                    setAnnouncement(announcementList.data)
                    //console.log(announcementList);
                } catch (error) {
                    console.error("에러남:", error);
                }
            }

            getAnnouncement3();
            //console.log(announcement);
            //console.log(announcement);
            //console.log(announcement);
        }, []);

    return (
        <>
            <h1 className="text-center my-3"> 공지사항 </h1>
            <table className="min-w-full bg-white border border-gray-300 my-2">
                <thead>
                    <tr className="bg-gray-200">
                        <th className="py-2 px-4 border-b border-gray-300">번호</th>
                        <th className="py-2 px-4 border-b border-gray-300">제목</th>
                        <th className="py-2 px-4 border-b border-gray-300">등록 날짜</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        announcement.map((item: AnnouncementInfo, index) => (
                            <tr className="hover:bg-gray-100" key={index}>
                                <td className="py-2 px-4 border-b border-gray-300 text-center">
                                    {item.announcementId}
                                </td>
                                <td className="py-2 px-4 border-b border-gray-300">
                                    {item.announcementTitle}
                                </td>
                                <td className="py-2 px-4 border-b border-gray-300 text-center">
                                    {/* {String(item.uploadTime).substring(0,12)} */}
                                    {item.uploadTime}
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
            
            {/* 페이지네이션 */}
            <ReactPaginate
                breakLabel="..."
                nextLabel="next >"
                nextClassName="bg-white border rounded px-3 py-0.5"
                onPageChange={undefined}
                pageRangeDisplayed={3}
                containerClassName="flex justify-center space-x-2 align-middle my-1"
                pageClassName="bg-white border rounded size-8 text-center py-0.5"
                pageCount={11}
                previousLabel="< prev"
                previousClassName="bg-white border rounded px-3 py-0.5"
                renderOnZeroPageCount={null}
            />
        </>
    );

};

export default Announcement;
