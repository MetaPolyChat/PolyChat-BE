package com.polychat.polychatbe.user.command.domain.service;

import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class UserRandomGenerateService {

    private final UserService userService;

    private final Random rand;

    public UserRandomGenerateService(UserService userService) {
        this.userService = userService;
        rand = new Random();
    }

    public String generateGoogleTempUserName() {
        rand.setSeed(System.currentTimeMillis());   // 시드는 id 생성시 최초 한번
        String newName;
        do {
            newName = "google-" + rand.nextInt(999999);
        } while (userService.findUserByUserName(newName) != null); //없으면 통과
        return newName;
    }


    /**
     * example : "BZS 285546 c"
     * 456,976,000,000
     */
    public String generatePlanetCode(){
        String result;
        do {
            result = "";
            result = result + getSingleCapital() + getSingleCapital() + getSingleCapital();
            result += " ";
            result = result + rand.nextInt(999999);
            result += " ";
            result = result + getSingleSmall();
        }while (userService.findUserByPlanet(result) != null);    //없으면 통과

        return result;
    }


    private char getSingleCapital(){
        return (char) ('A' + rand.nextInt(26));
    }

    private char getSingleSmall(){
        return (char) ('a' + rand.nextInt(26));
    }
}
