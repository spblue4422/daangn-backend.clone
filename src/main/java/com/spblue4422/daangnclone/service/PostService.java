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

    public List<Post> getAllPostsByIsComplete(int status) {
        return postRepository.findAllByIsCompleteAndIsDeleteFalse(status);
    }

    public List<Post> getAllPostsByUserId(long userId) {
        return postRepository.findAllByUserIdAndIsDeleteFalse(userId);
    }

    public Post getOnePost(long postId) {
        return postRepository.findById(postId).orElseThrow();
    }

    public Post addPost(long userId, int categoryId, String title, String content, int price) {
        final Post aPost = Post.builder()
            .userId(userId)
            .categoryId(categoryId)
            .title(title)
            .content(content)
            .price(price)
            .build();
        return postRepository.save(aPost);
    }

    public String modifyPost(long postId, int categoryId, String title, String content, int price) {
        Post post = postRepository.findByIdAndIsDeleteFalse(postId).orElseThrow();

        final Post mPost = Post.builder()
                .categoryId(categoryId)
                .title(title)
                .content(content)
                .price(price)
                .build();
        postRepository.save(mPost);

        return ("수정 성공");
    }

    public String removePost(long postId) {
        Post post = postRepository.findByIdAndIsDeleteFalse(postId).orElseThrow();

        Post rPost = Post.builder()
                .isDelete(true)
                .build();
        postRepository.save(rPost);

        return ("삭제 성공");
    }
}
