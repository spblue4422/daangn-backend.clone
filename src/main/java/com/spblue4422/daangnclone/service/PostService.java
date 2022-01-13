package com.spblue4422.daangnclone.service;


import com.spblue4422.daangnclone.model.entity.Post;
import com.spblue4422.daangnclone.repository.PostRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.*;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getOnePost(long postId) {
        return postRepository.findById(postId);
    }

    public Post addPost(long userId, int categoryId, String title, String content, int price) {
        final Post post = Post.builder()
            .userId(userId)
            .categoryId(categoryId)
            .title(title)
            .content(content)
            .price(price)
            .build();
        return postRepository.save(post);
    }
}
