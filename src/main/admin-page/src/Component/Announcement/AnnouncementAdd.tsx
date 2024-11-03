// import React, { useState } from 'react';
// import { Link, useNavigate } from 'react-router-dom';
// import { addAnnouncement } from '../../AxiosRequest/AnnouncementApi';

// const AnnouncementAdd: React.FC = () => {
//     const [isSubmitting, setIsSubmitting] = useState(false);
//     const navigate = useNavigate();

//     const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
//         e.preventDefault();
//         setIsSubmitting(true);

//         try {
//             const formData = new FormData(e.currentTarget);
//             await addAnnouncement(formData);  // 공지사항 추가 요청

//             alert('공지사항이 성공적으로 추가되었습니다.');
//             setIsSubmitting(false);  // navigate 전에 로딩 상태 초기화
//             navigate('/announcement');  // 페이지 이동
//         } catch (error) {
//             console.error('Error:', error);
//             alert('공지사항 추가에 실패했습니다.');
//             setIsSubmitting(false);  // 오류가 있을 경우 로딩 상태 초기화
//         }
//     };

//     return (
//         <>
//             <h2>공지사항 추가</h2>
//             <form className="min-w-80 w-3/5 flex flex-col py-2" onSubmit={handleSubmit}>
//                 <label htmlFor="title">제목</label>
//                 <input 
//                     id="title"
//                     className="rounded-md border my-2" 
//                     name="title" 
//                     type="text"
//                     required
//                 />
//                 <label htmlFor="uploaderId">작성 유저 번호</label>
//                 <input 
//                     id="uploaderId"
//                     className="rounded-md border my-2" 
//                     name="uploaderId" 
//                     type="number"
//                     required
//                 />
//                 <label htmlFor="content">내용</label>
//                 <textarea 
//                     id="content"
//                     className="rounded-md border h-48" 
//                     name="content"
//                     required
//                 />
//                 <button 
//                     type="submit" 
//                     className="bg-sky-500 rounded-md border w-1/2 self-center my-2"
//                     disabled={isSubmitting}
//                 >
//                     {isSubmitting ? '제출 중...' : '제출'}
//                 </button>
//             </form>
//             <Link to="/announcement">공지사항 목록</Link>
//         </>
//     );
// };

// export default AnnouncementAdd;

import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { addAnnouncement } from '../../AxiosRequest/AnnouncementApi';

const AnnouncementAdd: React.FC = () => {
    const [isSubmitting, setIsSubmitting] = useState(false);
    const navigate = useNavigate();

    const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        setIsSubmitting(true);

        try {
            const formData = new FormData(e.currentTarget);
            await addAnnouncement(formData);  // 공지사항 추가 요청

            alert('공지사항이 성공적으로 추가되었습니다.');
            setIsSubmitting(false);  // navigate 전에 로딩 상태 초기화
            navigate('/announcement');  // 페이지 이동
        } catch (error) {
            console.error('Error:', error);
            alert('공지사항 추가에 실패했습니다.');
            setIsSubmitting(false);  // 오류가 있을 경우 로딩 상태 초기화
        }
    };

    return (
        <div className="container mx-auto px-4 py-8">
            <div className="bg-white rounded-lg max-w-3xl mx-auto p-6">
                <h2 className="text-2xl font-bold mb-6 text-center">공지사항 추가</h2>
                <form className="flex flex-col gap-4" onSubmit={handleSubmit}>
                    <div>
                        <label htmlFor="title" className="block text-lg font-semibold mb-1">제목</label>
                        <input
                            id="title"
                            className="rounded-md border w-full p-2"
                            name="title"
                            type="text"
                            required
                        />
                    </div>
                    <div>
                        <label htmlFor="uploaderId" className="block text-lg font-semibold mb-1">작성 유저 번호</label>
                        <input
                            id="uploaderId"
                            className="rounded-md border w-full p-2"
                            name="uploaderId"
                            type="number"
                            required
                        />
                    </div>
                    <div>
                        <label htmlFor="content" className="block text-lg font-semibold mb-1">내용</label>
                        <textarea
                            id="content"
                            className="rounded-md border w-full p-2 h-48"
                            name="content"
                            required
                        />
                    </div>
                    <div className="mt-6 flex flex-col sm:flex-row justify-between gap-4">
                        <Link
                            to="/announcement"
                            className="w-full sm:basis-1/3 px-4 py-2 bg-gray-500 hover:bg-gray-600 text-white font-semibold rounded-lg text-center transition duration-300"
                        >
                            목록
                        </Link>
                        <button
                            type="submit"
                            className={`w-full sm:basis-1/3 px-4 py-2 ${isSubmitting ? "bg-gray-400" : "bg-sky-500 hover:bg-sky-600"} text-white font-semibold rounded-lg transition duration-300`}
                            disabled={isSubmitting}
                        >
                            {isSubmitting ? '제출 중...' : '제출'}
                        </button>
                    </div>
                </form>
            </div>
        </div>
    );
};

export default AnnouncementAdd;
