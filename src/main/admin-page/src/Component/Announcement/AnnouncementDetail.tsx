import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import { getAnnouncementById } from "../../AxiosRequest/AnnouncementApi";

interface AnnouncementInfo {
    announcementId: number;
    announcementTitle: string;
    announcementContent: string;
    uploaderName: string;
    uploaderNo: number;
    uploadTime: string;
    lastUpdatedTime: string;
}

const AnnouncementDetail: React.FC = () => {

    const { announcementId } = useParams();

    const [announcement, setAnnouncement] = useState<AnnouncementInfo | null>(null);

    const [title, setTitle] = useState<string | undefined>();
    const [content, setContent] = useState<string | undefined>();

    const onTitleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setTitle(event.target.value);
    }

    const onContentChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setContent(event.target.value);
    }


    useEffect(
        () => {
            async function getOneAnnouncement() {
                try {
                    const announcementInfo = await getAnnouncementById(Number(announcementId));
                    setAnnouncement(announcementInfo.data);
                    setTitle(announcementInfo.data.announcementTitle);
                    setContent(announcementInfo.data.announcementContent);
                } catch (error) {
                    console.error("에러남:", error);
                }
            }

            getOneAnnouncement();

            // if (announcement){
            //     setTitle(announcement.announcementTitle);
            // }
        }, []);

    return (
        <>
            <h2>공지사항 {announcementId}</h2>
            <form className="min-w-80 w-3/5 flex flex-col py-2" method="put" action={`http://localhost:8000/announcement/${announcementId}`}>
                <label>제목</label>
                <input className="rounded-md border my-2" name="title" type="text" onChange={onTitleChange} value={title} />
                <label>보내는 사람 id</label>
                <input className="rounded-md border my-2" name=" uploaderNo" type="text" value={announcement?.uploaderNo} />
                <p>등록 시간 : {announcement?.uploadTime}</p>
                <p>최종 변경 시간: {announcement?.lastUpdatedTime}</p>
                <label>내용</label>
                <input className="rounded-md border h-48 " name="content" type="text" onChange={onContentChange} value={content} />
                <button className="bg-sky-500 rounded-md border w-1/2 self-center my-2">수정</button>
            </form>
            <Link to="/announcement">공지사항 목록</Link>
        </>
    );



};

export default AnnouncementDetail;
