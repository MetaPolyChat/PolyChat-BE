import React, { useEffect, useState } from 'react'
import { ArrowLeft } from 'lucide-react'
import { useParams } from 'react-router-dom'

interface Item {
    id: number
    name: string
    description: string
    imageUrl: string
    type: string
    price: number
    createdAt: string
    senderId: string
}

async function fetchItemById(itemId: any): Promise<Item | null> {
    return {
        id: itemId,
        name: '아이템 이름',
        description: '아이템 설명입니다.',
        imageUrl: '/placeholder.svg', // 실제 이미지 URL을 여기에 추가하세요.
        type: '아이템 유형',
        price: 10000,
        createdAt: '2023-01-01T12:00:00Z',
        senderId: '판매자123',
    }
}

export default function ItemDetailPage() {
    const { itemId } = useParams();
    const [item, setItem] = useState<Item | null>(null)

    useEffect(() => {
        fetchItemById(itemId).then(data => {
            if (data) setItem(data)
        })
    }, [itemId])

    if (!item) {
        return <div>아이템을 찾을 수 없습니다.</div>
    }

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
                <h2 className="text-2xl font-bold mb-4 text-center">{item.name}</h2>
                <div className="relative w-48 h-48 mx-auto rounded-lg overflow-hidden mb-6">
                    <img
                        src={item.imageUrl || '/placeholder.svg'}
                        alt={item.name}
                        className="w-full h-full object-cover transition-all duration-300 hover:scale-105"
                    />
                </div>
                <div className="grid grid-cols-1 sm:grid-cols-2 gap-6 text-gray-700">
                    <div className="sm:col-span-2">
                        <h3 className="text-lg font-semibold">상세 설명</h3>
                        <p className="mt-1">{item.description}</p>
                    </div>
                    <div>
                        <h3 className="text-lg font-semibold">아이템 번호</h3>
                        <p className="mt-1">{item.id}</p>
                    </div>
                    <div>
                        <h3 className="text-lg font-semibold">유형</h3>
                        <p className="mt-1">{item.type}</p>
                    </div>
                    <div>
                        <h3 className="text-lg font-semibold">가격</h3>
                        <p className="mt-1">{item.price.toLocaleString()}원</p>
                    </div>
                    <div>
                        <h3 className="text-lg font-semibold">등록 날짜</h3>
                        <p className="mt-1">
                            {"2222.222.22"}
                        </p>
                    </div>
                    <div>
                        <h3 className="text-lg font-semibold">판매자 ID</h3>
                        <p className="mt-1">{item.senderId}</p>
                    </div>
                </div>
                <div className="mt-8 flex justify-center">
                    <button className="w-full sm:w-2/3 md:w-1/2 lg:w-1/3 py-2 bg-indigo-600 text-white font-semibold rounded-lg hover:bg-indigo-700 transition duration-300">
                        구매하기
                    </button>
                </div>
            </div>
        </div>
    )
}
