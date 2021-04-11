package com.cbrl.spring.cloud.domain.user.controller;

import com.cbrl.spring.cloud.base.BaseController;
import com.cbrl.spring.cloud.base.response.ApiResponse;
import com.cbrl.spring.cloud.domain.user.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/api/users")
public class UserController extends BaseController<UserService> {

    @GetMapping("/{user-id}")
    public ApiResponse getUser(@PathVariable("user-id") Long id) {
        return run(service.getUser(id));
    }

}
