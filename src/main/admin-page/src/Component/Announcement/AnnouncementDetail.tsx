
import React, { FormEvent, useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { getAnnouncementById, updateAnnouncement } from '../../AxiosRequest/AnnouncementApi';
interface AnnouncementInfo {
    announcementId: number;
    announcementTitle: string;
    announcementContent: string;
    uploaderName: string;
    uploaderNo: number;
    uploadTime: string;
    lastUpdatedTime: string;
}

interface AnnouncementProps {
    announcementId: string;
    announcement?: {
        uploaderNo: string;
        uploadTime: string;
        lastUpdatedTime: string;
    };
}

const AnnouncementForm: React.FC = () => {
    const [title, setTitle] = useState<string>('');
    const [content, setContent] = useState<string>('');
    const [loading, setLoading] = useState<boolean>(false);

    const onTitleChange = (e: React.ChangeEvent<HTMLInputElement>) => setTitle(e.target.value);
    const onContentChange = (e: React.ChangeEvent<HTMLTextAreaElement>) => setContent(e.target.value);


    const { announcementId } = useParams();

    const [announcement, setAnnouncement] = useState<AnnouncementInfo | null>(null);

    //     const [title, setTitle] = useState<string | undefined>();
    //     const [content, setContent] = useState<string | undefined>();

    //     const onTitleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    //         setTitle(event.target.value);
    //     }

    //     const onFormSubmit = (event:any)=>{
    //         event.preventDefault

    //     }

    //     const onContentChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    //         setContent(event.target.value);
    //     }


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


    const handleSubmit = async (e: FormEvent) => {
        e.preventDefault();
        setLoading(true);
        let isUpdateSuccessful = false;

        try {
            await updateAnnouncement(Number(announcementId), {
                title,
                uploaderId: announcement?.uploaderNo,
                content,
            });
            isUpdateSuccessful = true; // 성공하면 플래그를 true로 설정
        } catch (error) {
            console.error("에러:", error);
        } finally {
            setLoading(false); // 로딩 상태 해제
            if (isUpdateSuccessful) {
                window.location.reload(); // 업데이트 성공 시 새로고침
            }
        }
    };

    return (
        <div className="container mx-auto px-4 py-8">
            {/* <button
                onClick={() => window.history.back()}
                className="inline-flex items-center mb-4 text-blue-500 hover:text-blue-600"
            >
                목록으로 돌아가기
            </button> */}
            <div className="bg-white rounded-lg max-w-3xl mx-auto p-6">
                <h2 className="text-2xl font-bold mb-4 text-center">공지사항 수정</h2>
                <form className="flex flex-col gap-4" onSubmit={handleSubmit}>
                    <div>
                        <label className="block text-lg font-semibold mb-1">제목</label>
                        {/* <label>{title}</label> */}

                        <input
                            className="rounded-md border w-full p-2"
                            name="title"
                            type="text"
                            onChange={onTitleChange}
                            value={title}
                        />
                    </div>

                    {/* 작성자 및 등록 날짜 묶음 */}
                    <div className="flex flex-col sm:flex-row gap-6">
                        {/* 작성자 정보 */}
                        <div className="flex-1">
                            <label className="block text-lg font-semibold mb-1">작성자</label>
                            <p className="text-gray-700">{announcement?.uploaderName || ''}</p>
                        </div>

                        {/* 등록 날짜 정보 */}
                        <div className="flex-1">
                            <div className="text-gray-700">
                                <p className="font-semibold">등록 시간: <span className="font-normal">{announcement?.uploadTime}</span></p>
                                <p className="font-semibold">최종 변경 시간: <span className="font-normal">{announcement?.lastUpdatedTime}</span></p>
                            </div>
                        </div>
                    </div>

                    <div>
                        <label className="block text-lg font-semibold mb-1">내용</label>
                        <textarea
                            className="rounded-md border w-full p-2 h-48"
                            name="content"
                            onChange={onContentChange}
                            value={content}
                        />
                    </div>
                    {/* 목록과 수정 버튼을 좌우 배치 */}
                    <div className="mt-6 flex flex-col sm:flex-row justify-between gap-4">
                        <button
                            type="button"
                            onClick={() => window.history.back()}
                            className="w-full sm:basis-1/3 px-4 py-2 bg-gray-500 hover:bg-gray-600 text-white font-semibold rounded-lg transition duration-300"
                        >
                            목록
                        </button>
                        <button
                            type="submit"
                            disabled={loading}
                            className={`w-full sm:basis-1/3 px-4 py-2 ${loading ? "bg-gray-400" : "bg-sky-500 hover:bg-sky-600"} text-white font-semibold rounded-lg transition duration-300`}
                        >
                            {loading ? "수정 중..." : "수정"}
                        </button>
                    </div>

                </form>
            </div>
        </div>
    );
};

export default AnnouncementForm;
