import React, { useState } from "react";
import { useNavigate } from "react-router-dom"; // useNavigate 훅 추가
import styled from "styled-components";
import {LoginAxios} from "../AxiosRequest/Axios";

// 스타일 컴포넌트 정의
const LoginContainer = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f5f5f5;
`;

const Form = styled.form`
  display: flex;
  flex-direction: column;
  padding: 2rem;
  background-color: white;
  box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
  border-radius: 8px;
  width: 300px;
`;

const Input = styled.input`
  margin-bottom: 1rem;
  padding: 0.75rem;
  font-size: 1rem;
  border: 1px solid #ccc;
  border-radius: 4px;
  &:focus {
    outline: none;
    border-color: #007bff;
  }
`;

const Button = styled.button`
  padding: 0.75rem;
  font-size: 1rem;
  color: white;
  background-color: #007bff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-bottom: 1rem;
  &:hover {
    background-color: #0056b3;
  }
`;

const Title = styled.h1`
  font-size: 2rem;
  margin-bottom: 2rem;
  color: #333;
`;

const SecondaryButton = styled.button`
  padding: 0.5rem;
  font-size: 0.9rem;
  color: #007bff;
  background-color: transparent;
  border: none;
  cursor: pointer;
  text-decoration: underline;
  &:hover {
    color: #0056b3;
  }
`;

const ButtonContainer = styled.div`
  display: flex;
  justify-content: space-between;
`;

export const Login: React.FC = () => {
    const [id, setId] = useState<string>("");
    const [password, setPassword] = useState<string>("");
    const navigate = useNavigate(); // useNavigate 훅 사용

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();

        try {
            // 로그인 로직 처리
            const response = await LoginAxios({ id, password });

            if (response) {
                console.log("Login successful");
                navigate("/home"); // 로그인 성공 시 /home으로 리디렉션
            }
        } catch (error) {
            console.error("Login failed", error);
            // 실패 시 처리 로직 추가 가능 (예: 경고 메시지)
        }
    };

    return (
        <LoginContainer>
            <Title>Admin Login</Title> {/* 타이틀 */}
            <Form onSubmit={handleSubmit}>
                <Input
                    type="text"
                    placeholder="Enter your ID"
                    value={id}
                    onChange={(e) => setId(e.target.value)}
                />
                <Input
                    type="password"
                    placeholder="Enter your password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />
                <Button type="submit">Login</Button> {/* /home으로 리디렉션 */}
                {/* 추가 버튼들 */}
                <ButtonContainer>
                    <SecondaryButton type="button">회원가입</SecondaryButton>
                    <SecondaryButton type="button">비밀번호 찾기</SecondaryButton>
                </ButtonContainer>
            </Form>
        </LoginContainer>
    );
};