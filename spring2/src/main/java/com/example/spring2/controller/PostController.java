package com.example.spring2.controller;

import com.example.spring2.entity.Post;
import com.example.spring2.entity.repository.UserRepository;
import com.example.spring2.entity.repository.PostRepository;
import com.example.spring2.dto.request.PostRequest;
import com.example.spring2.dto.response.PostResponse;
import com.example.spring2.service.PostService;
import com.example.spring2.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class PostController {


    private final PostRepository postRepository;
    private final PostService service;
    private final UserRepository memberRepository;
    private final SignupService signupService;

    @PostMapping("/post")
    public String create(@RequestBody PostRequest postRequest) {
        return service.create(postRequest);
    }

    @PutMapping("/edit/{id}")
    public void update(@RequestBody PostRequest request, @PathVariable Long id) {
        service.update(request, id);
    }

    @PatchMapping("/new/{id}")
    public void updateEx(@RequestBody PostRequest request, @PathVariable Long id) {
        service.updateEx(request, id);
    }

    @GetMapping("/get")
    public List<Post> read() {
        return service.read();
    }

    @GetMapping("/{id}")
    public PostResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
