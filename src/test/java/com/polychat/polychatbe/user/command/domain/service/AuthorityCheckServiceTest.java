package com.polychat.polychatbe.user.command.domain.service;

import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorityCheckServiceTest {

    @DisplayName("유저 계정정보를 수정할 권한이 있는지를 검사")
    public void hasAccountModifyAccount(){
        //assert했을때 true가 나옴
    }


    @DisplayName("계정정보를 수정할 권한이 없는 경우를 검사")
    public void dontHasAccountModifyAccount(){
        //assert로 false가 나오는지 테스트
    }
}