import React, { useEffect, useState } from 'react'
import { ArrowLeft } from 'lucide-react'
import { useParams } from 'react-router-dom'
import { getItemById } from '../../AxiosRequest/ItemApi'

interface Item {
    itemId: number
    itemName: string
    itemDescription: string
    itemImageUrl: string
    itemType: string
    price: number
    createdAt: string
    senderId: string
}

export default function ItemDetailPage() {
    const { itemId } = useParams();
    const [item, setItem] = useState<Item | null>(null);
    const [loading, setLoading] = useState<boolean>(true); // 로딩 상태 추가

    useEffect(() => {
        async function getOneItem() {
            try {
                const itemInfo = await getItemById(Number(itemId));
                if (itemInfo && itemInfo.data) {
                    setItem(itemInfo.data.response);  // 데이터 업데이트
                } else {
                    console.log("데이터가 없습니다.");
                }
            } catch (error) {
                console.error("에러남: ", error);
            } finally {
                setLoading(false);  // 로딩이 끝났음을 표시
            }
        }

        getOneItem();
    }, [itemId]);

    //로딩 중이면 로딩 표시
    if (loading) {
        return <div>아이템 데이터를 불러오는 중입니다...</div>;
    }

    // 데이터가 없을 때 처리
    if (!item) {
        return <div>아이템을 찾을 수 없습니다.</div>;
    }

    console.log(item);

    return (
        <div className="container mx-auto px-4 py-8">
            <button
                onClick={() => window.history.back()}
                className="inline-flex items-center mb-4 text-blue-500 hover:text-blue-600"
            >
                <ArrowLeft className="mr-2 h-4 w-4" />
                목록으로 돌아가기
            </button>
            <div className="bg-white rounded-lg max-w-3xl mx-auto p-6">
                <h2 className="text-2xl font-bold mb-4 text-center">{item.itemName}</h2> 
                {/* <div className="relative w-48 h-48 mx-auto rounded-lg overflow-hidden mb-6">
                    <img
                        src={item.itemImageUrl || '/placeholder.svg'} 
                        alt={item.itemName} 
                        className="w-full h-full object-cover transition-all duration-300 hover:scale-105"
                    />
                </div> */}
                <div className="grid grid-cols-1 sm:grid-cols-2 gap-6 text-gray-700">
                    <div className="sm:col-span-2">
                        <h3 className="text-lg font-semibold">상세 설명</h3>
                        <p className="mt-1">{item.itemDescription}</p>
                    </div>
                    <div>
                        <h3 className="text-lg font-semibold">아이템 번호</h3>
                        <p className="mt-1">{item.itemId}</p>
                    </div>
                    <div>
                        <h3 className="text-lg font-semibold">유형</h3>
                        <p className="mt-1">{item.itemType}</p> 
                    </div>
                    <div>
                        <h3 className="text-lg font-semibold">가격</h3>
                        <p className="mt-1">{item.price}원</p> 
                    </div>
                    <div>
                        <h3 className="text-lg font-semibold">등록 날짜</h3>
                        <p className="mt-1">
                            {item.createdAt}
                        </p>
                    </div>
                </div>
                {/* <div className="mt-8 flex justify-center">
                    <button className="w-full sm:w-2/3 md:w-1/2 lg:w-1/3 py-2 bg-indigo-600 text-white font-semibold rounded-lg hover:bg-indigo-700 transition duration-300">
                        구매하기
                    </button>
                </div> */}
            </div>
        </div>
    )
}
