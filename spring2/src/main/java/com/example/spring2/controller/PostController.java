package com.example.spring2.controller;

import com.example.spring2.entity.Post;
import com.example.spring2.entity.repository.PostRepository;
import com.example.spring2.payload.request.PostRequest;
import com.example.spring2.payload.response.PostResponse;
import com.example.spring2.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class PostController {


    private final PostRepository postRepository;
    private final PostService service;

    @PostMapping("/post")
    public String create(@RequestBody PostRequest postRequest) {
        return service.create(postRequest);
    }

    @PatchMapping("{id}")
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
