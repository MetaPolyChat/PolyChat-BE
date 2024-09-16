import React from "react";
import { Outlet, Link } from "react-router-dom";
import styled from "styled-components";
import Sidebar from "./Sidebar";

const LayoutContainer = styled.div`
  display: flex;
`;

// const Sidebar = styled.nav`
//   width: 250px;
//   background-color: #f5f5f5;
//   padding: 1rem;
//   height: 100vh;
// `;

const MainContent = styled.main`
  flex-grow: 1;
  padding: 2rem;
`;

const Header = styled.header`
  height: 60px;
  background-color: #333;
  color: white;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 1rem;
`;

const Layout: React.FC = () => {
    return (
        <>
            <Header>
                <h1>Admin Dashboard</h1>
                <nav>
                    <Link to="/">Login</Link> | <Link to="/account">Account</Link>
                </nav>
            </Header>
            <LayoutContainer>
                <Sidebar/>
                <MainContent>
                    <Outlet />
                </MainContent>
            </LayoutContainer>
        </>
    );
};

export default Layout;
