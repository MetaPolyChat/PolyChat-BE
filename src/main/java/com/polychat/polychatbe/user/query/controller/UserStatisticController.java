package com.polychat.polychatbe.user.query.controller;

import com.polychat.polychatbe.common.utils.ApiUtils;
import com.polychat.polychatbe.user.query.dto.RegistPerDayDTO;
import com.polychat.polychatbe.user.query.service.UserSearchService;
import com.polychat.polychatbe.user.query.service.UserStatisticService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin/user")
public class UserStatisticController {

    private UserStatisticService userStatisticService;

    public UserStatisticController(UserStatisticService userStatisticService) {
        this.userStatisticService = userStatisticService;
    }

    @GetMapping("count-day")
    public ApiUtils.ApiResult<List<RegistPerDayDTO>> countDay(@RequestParam int range){
        return ApiUtils.success(
                userStatisticService.countRegisterDayRange(range)
        );
    }
}
