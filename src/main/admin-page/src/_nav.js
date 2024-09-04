import React from 'react'
import CIcon from '@coreui/icons-react'
import {
  cilBan,
  cilBullhorn,
  cilGift,
  cilPeople,
  cilSpeedometer,
} from '@coreui/icons'
import { CNavGroup, CNavItem, CNavTitle } from '@coreui/react'

const _nav = [
  {
    component: CNavItem,
    name: '대시보드',
    to: '/dashboard',
    icon: <CIcon icon={cilSpeedometer} customClassName="nav-icon" />,
  },
  {
    component: CNavTitle,
    name: '상세 관리',
  },
  {
    component: CNavItem,
    name: '회원관리',
    to: '/manage/user',
    icon: <CIcon icon={cilPeople} customClassName="nav-icon" />,
  },
  {
    component: CNavItem,
    name: '정지회원',
    to: '/manage/ban',
    icon: <CIcon icon={cilBan} customClassName="nav-icon" />,
  },

  {
    component: CNavItem,
    name: '공지사항',
    to: '/manage/announcement',
    icon: <CIcon icon={cilBullhorn} customClassName="nav-icon" />,
  },
  {
    component: CNavItem,
    name: '상점 아이템',
    to: '/manage/store',
    icon: <CIcon icon={cilGift} customClassName="nav-icon" />,
  },
]

export default _nav
