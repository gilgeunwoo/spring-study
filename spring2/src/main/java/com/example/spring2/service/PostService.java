package com.example.spring2.service;

import com.example.spring2.entity.Post;
import com.example.spring2.entity.repository.PostRepository;
import com.example.spring2.dto.request.PostRequest;
import com.example.spring2.dto.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public String create(PostRequest postRequest) {
        postRepository.save(Post.builder()
                .title(postRequest.getTitle())
                .contents(postRequest.getContents())
                .build());
        return "success!";
    }

    @Transactional
    public void update(PostRequest request, Long id) {
        postRepository.findById(id)
                .map(newPost -> newPost.update(
                        request.getTitle(),
                        request.getContents()
                ))
                .orElseThrow(RuntimeException::new);
    }

    public void updateEx(PostRequest request, Long id) {
        postRepository.deleteById(id);
        postRepository.save(Post.builder()
                .title(request.getTitle())
                .contents(request.getContents())
                .build());
    }

    public List<Post> read() {
        return postRepository.findAll();
    }

    public PostResponse get(Long id) {
        return postRepository.findById(id)
                .map(post -> {
                    PostResponse response = PostResponse.builder()
                            .title(post.getTitle())
                            .contents(post.getContents())
                            .build();
                    return response;
                })
                .orElseThrow(RuntimeException::new);
    }

    @Transactional
    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}