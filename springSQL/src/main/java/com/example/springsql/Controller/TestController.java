package com.example.springsql.Controller;

import com.example.springsql.entity.User;
import com.example.springsql.service.TestService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TestController {

    private final TestService testService;

    @GetMapping(value = "api/test")
    public String test() {
        String json = "{name : 'icecream'}";
        return json;
    }

    @GetMapping(value = "/api/user")
    public List<User> getUserList() {
        return testService.getUserList();
    }

    @GetMapping(value = "/api/user/{userId}")
    public String getUser(@PathVariable Long userId) {
        return testService.getUser(userId);
    }

}