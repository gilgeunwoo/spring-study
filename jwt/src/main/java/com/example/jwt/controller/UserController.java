package com.example.jwt.controller;

import com.example.jwt.entity.User;
import com.example.jwt.entity.UserRepository;
import com.example.jwt.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    final String BIRTH = "001200";
    final String EMAIL = "aabbcc@gmail.com";
    final String NICKNAME = "침착맨";

    User user = User.builder()
            .userEmail(EMAIL)
            .userBirth(BIRTH)
            .userNickname(NICKNAME)
            .roles(Collections.singletonList("ROLE_USER"))
            .build();


    @PostMapping("/join")
    @Transactional
    public String join() {
        log.info("로그인 시도됨");

        userRepository.save(user);

        return user.toString();
    }

    @PostMapping("/login")
    @Transactional
    public String login(@RequestBody Map<String, String> user) {
        log.info("user email = {}", user.get("email"));

        User member = userRepository.findByUserEmail(user.get("email"))
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 email입니다."));

        return jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
    }
}
