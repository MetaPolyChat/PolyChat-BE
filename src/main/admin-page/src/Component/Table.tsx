import React from 'react';

interface TableHeaderCellProps {
    children: React.ReactNode;
    columnKey: string;
    sortingColumn: string | null;
    sortingMethod: string | null;
    handleSort: (column: string) => void;
}

interface TableCellProps {
    children: React.ReactNode;
    className?: string;
    onClick?: () => void;
    asLink?: boolean;
    cellKey?: string | number; // cellKey를 선택적 속성으로 변경
}

// Table 컴포넌트
export const Table = ({ children }: { children: React.ReactNode }) => (
    <table className="min-w-full bg-white border border-gray-300 my-2">
        {children}
    </table>
);

// TableHeader 컴포넌트
export const TableHeader = ({ children }: { children: React.ReactNode }) => (
    <thead>
        <tr className="bg-gray-200" key={String(children)}>
            {children}
        </tr>
    </thead>
);

// TableBody 컴포넌트
export const TableBody = ({ children }: { children: React.ReactNode }) => (
    <tbody>
        {children}
    </tbody>
);

// TableRow 컴포넌트
export const TableRow = ({ children}: { children: React.ReactNode}) => (
    <tr className="hover:bg-gray-100 cursor-pointer">
        {children}
    </tr>
);

// TableCell 컴포넌트
export const TableCell = ({ children, className = '', onClick, asLink, cellKey }: TableCellProps) => (
    <td
        key={cellKey} // key는 JSX 요소에서 사용
        className={`py-2 px-4 border-b border-gray-300 text-center ${className} ${asLink ? 'cursor-pointer hover:bg-gray-100' : ''}`}
        onClick={onClick}
    >
        {children}
    </td>
);

export const TableHeaderNormalCell = ({ children }: { children: React.ReactNode }, key: string | number) => (
    <th key={key}
        className="py-2 px-4 border-b border-gray-300 cursor-pointer"
    >{children}</th>
);

export const TableHeaderCell = ({
    children,
    columnKey,
    sortingColumn,
    sortingMethod,
    handleSort,
}: TableHeaderCellProps) => (
    <th key={columnKey}
        className="py-2 px-4 border-b border-gray-300 cursor-pointer"
        onClick={() => handleSort(columnKey)}
    >
        {children} {sortingColumn === columnKey && (sortingMethod === 'ASC' ? '▲' : '▼')}
    </th>
);