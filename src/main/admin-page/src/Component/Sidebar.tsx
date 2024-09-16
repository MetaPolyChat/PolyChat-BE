import { Link } from 'react-router-dom';
import styles from './Sidebar.module.css';

const Sidebar: React.FC = () => {
  return (
    <nav className={styles.sidebar}>
      <ul>
        <li>
          <Link to="/home" className={styles.menuItem}>대쉬보드</Link>
        </li>
        <li>
          <Link to="/account" className={styles.menuItem}>유저관리</Link>
        </li>
        <li>
          <Link to="/announcement" className={styles.menuItem}>공지사항</Link>
        </li>
      </ul>
    </nav>
  );
};

export default Sidebar;