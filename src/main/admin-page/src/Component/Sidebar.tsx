import { NavLink } from 'react-router-dom';
import styles from './Sidebar.module.css';

const Sidebar: React.FC = () => {
  return (
    <nav className={styles.sidebar}>
      <ul>
        <li>
          <NavLink to="/home" className={({isActive}) => isActive? styles.selected: styles.menuItem}>대쉬보드</NavLink>
        </li>
        <li>
          <NavLink to="/account" className={({isActive}) => isActive? styles.selected: styles.menuItem}>회원 관리</NavLink>
        </li>
        <li>
          <NavLink to="/blockUser" className={({isActive}) => isActive? styles.selected: styles.menuItem}>정지회원</NavLink>
        </li>
        <li>
          <NavLink to="/announcement" className={({isActive}) => isActive? styles.selected: styles.menuItem}>공지사항</NavLink>
        </li>
        <li>
          <NavLink to="/item" className={({isActive}) => isActive? styles.selected: styles.menuItem}>상점 아이템</NavLink>
        </li>
        {/* <li>
          <Link to="/inquiry" className={styles.menuItem}>문의사항</Link>
        </li> */}
        <li>
          <NavLink to="/withdrawUser" className={({isActive}) => isActive? styles.selected: styles.menuItem}>탈퇴 회원 관리</NavLink>
        </li>
      </ul>
    </nav>
  );
};

export default Sidebar;