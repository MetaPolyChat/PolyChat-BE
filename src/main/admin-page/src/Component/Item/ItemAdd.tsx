import { useState } from 'react'

const AddItem = ()=> {
    const [isSubmitting, setIsSubmitting] = useState(false)
    const [message, setMessage] = useState('')
    const [previewImage, setPreviewImage] = useState<string | null>(null)

    async function handleSubmit(event: React.FormEvent<HTMLFormElement>) {
        event.preventDefault()
        setIsSubmitting(true)
        setMessage('')

        const formData = new FormData(event.currentTarget)

        console.log("제출할 데이터");
        console.log(formData);

        // try {
        //   // 여기서 Axios로 데이터 추가 로직을 별도의 함수에서 처리하세요.
        //   const result = await addItem(formData)
        //   setMessage(result.message)

        //   if (result.success) {
        //     event.currentTarget.reset()
        //     setPreviewImage(null)
        //   }
        // } catch (error) {
        //   console.error('Error adding item:', error)
        //   setMessage('아이템 추가 중 오류가 발생했습니다.')
        // } finally {
        //   setIsSubmitting(false)
        // }
    }

    function handleImageChange(event: React.ChangeEvent<HTMLInputElement>) {
        const file = event.target.files?.[0]
        if (file) {
            const reader = new FileReader()
            reader.onloadend = () => {
                setPreviewImage(reader.result as string)
            }
            reader.readAsDataURL(file)
        }
    }

    return (
        <div className="max-w-md mx-auto mt-8">
            <h1 className="text-2xl font-bold mb-4">새 아이템 추가</h1>
            <form onSubmit={handleSubmit} className="space-y-4">
                <div>
                    <label htmlFor="name" className="block text-sm font-medium text-gray-700">아이템 이름</label>
                    <input
                        type="text"
                        id="name"
                        name="name"
                        required
                        className="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50"
                    />
                </div>
                <div>
                    <label htmlFor="description" className="block text-sm font-medium text-gray-700">아이템 설명</label>
                    <textarea
                        id="description"
                        name="description"
                        required
                        className="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50"
                    />
                </div>
                <div>
                    <label htmlFor="type" className="block text-sm font-medium text-gray-700">아이템 유형</label>
                    <input
                        type="text"
                        id="type"
                        name="type"
                        required
                        className="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50"
                    />
                </div>
                <div>
                    <label htmlFor="price" className="block text-sm font-medium text-gray-700">가격</label>
                    <input
                        type="number"
                        id="price"
                        name="price"
                        required
                        min="0"
                        step="0.01"
                        className="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50"
                    />
                </div>
                <div>
                    <label htmlFor="senderId" className="block text-sm font-medium text-gray-700">보내는 사람 ID</label>
                    <input
                        type="text"
                        id="senderId"
                        name="senderId"
                        required
                        className="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50"
                    />
                </div>
                <div>
                    <label htmlFor="image" className="block text-sm font-medium text-gray-700">아이템 이미지</label>
                    <input
                        type="file"
                        id="image"
                        name="image"
                        accept="image/*"
                        onChange={handleImageChange}
                        className="mt-1 block w-full text-sm text-gray-500 file:mr-4 file:py-2 file:px-4 file:rounded-full file:border-0 file:text-sm file:font-semibold file:bg-indigo-50 file:text-indigo-700 hover:file:bg-indigo-100"
                    />
                </div>
                {previewImage && (
                    <div className="mt-4">
                        <img src={previewImage} alt="Preview" className="w-48 h-48 rounded-md" />
                    </div>
                )}
                <button
                    type="submit"
                    disabled={isSubmitting}
                    className="w-full py-2 px-4 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500 disabled:opacity-50"
                >
                    {isSubmitting ? '추가 중...' : '아이템 추가'}
                </button>
            </form>
            {message && (
                <p className="mt-4 text-sm text-center text-green-600">{message}</p>
            )}
        </div>
    )
}


export default AddItem;