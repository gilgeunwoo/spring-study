package com.example.springsql.service;

import com.example.springsql.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.h2.engine.User;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TestService {

    private UserRepository userRepository;

    public List<User> getUserList() {
        return userRepository.findAllByOrOrderByIdDesc();
    }

    public String getUser(long userId) {
        return "{\n" +
                "\t\t\"id\": 1,\n" +
                "\t\t\"name\": \"김길동\",\n" +
                "\t\t\"age\": \"길동중\"\n" +
                "\t}";

    }
}