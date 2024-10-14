import React, { useState } from 'react';
import { useParams, Link, useNavigate } from 'react-router-dom';


interface AnnouncementInfo {
    announcementId: number;
    announcementTitle: string;
    announcementContent: string;
    uploaderName: string;
    uploaderNo: number;
    uploadTime: string;
    lastUpdatedTime: string;
}

const AnnouncementAdd: React.FC = () => {


    const { announcementId } = useParams();

    const [announcement, setAnnouncement] = useState<AnnouncementInfo | null>(null);

    const [title, setTitle] = useState<string | undefined>();
    const [content, setContent] = useState<string | undefined>();

    const [isSubmitting, setIsSubmitting] = useState(false);
    const navigate = useNavigate();

    const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        setIsSubmitting(true);

        try {
            const formData = new FormData(e.currentTarget);
            const response = await fetch('http://localhost:8000/announcement', {
                method: 'POST',
                body: formData,
            });

            if (response.ok) {
                alert('공지사항이 성공적으로 추가되었습니다.');
                navigate('/announcement');
            } else {
                alert('공지사항 추가에 실패했습니다.');
            }
        } catch (error) {
            console.error('Error:', error);
            alert('오류가 발생했습니다.');
        } finally {
            setIsSubmitting(false);
        }
    };

    return (
        <>
            <h2>공지사항 추가</h2>
            <form className="min-w-80 w-3/5 flex flex-col py-2" onSubmit={handleSubmit}>
                <label htmlFor="title">제목</label>
                <input 
                    id="title"
                    className="rounded-md border my-2" 
                    name="title" 
                    type="text"
                    required
                />
                <label htmlFor="uploaderId">보내는 사람 id</label>
                <input 
                    id="uploaderId"
                    className="rounded-md border my-2" 
                    name="uploaderId" 
                    type="number"
                    required
                />
                <label htmlFor="content">내용</label>
                <textarea 
                    id="content"
                    className="rounded-md border h-48" 
                    name="content"
                    required
                />
                <button 
                    type="submit" 
                    className="bg-sky-500 rounded-md border w-1/2 self-center my-2"
                    disabled={isSubmitting}
                >
                    {isSubmitting ? '제출 중...' : '제출'}
                </button>
            </form>
            <Link to="/announcement">공지사항 목록</Link>
        </>
    );
};

export default AnnouncementAdd;