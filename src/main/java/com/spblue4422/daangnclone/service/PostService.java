package com.spblue4422.daangnclone.service;


import com.spblue4422.daangnclone.model.entity.Post;
import com.spblue4422.daangnclone.DTO.Post.*;
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
        //return postRepository.findById(postId).orElseThrow();
        return postRepository.findById(postId).orElse(null);
    }

    public Post addPost(AddPostRequestDTO req, long userId) {
        Post aPost = Post.builder()
            .userId(userId)
            .categoryId(req.getCategoryId())
            .title(req.getTitle())
            .content(req.getContent())
            .price(req.getPrice())
            .build();
        return postRepository.save(aPost);
    }

    public String modifyPost(ModifyPostRequestDTO req) {
        //Post post = postRepository.findByIdAndIsDeleteFalse(req.getPostId()).orElseThrow();

        Post mPost = Post.builder()
                .postId(req.getPostId())
                .categoryId(req.getCategoryId())
                .title(req.getTitle())
                .content(req.getContent())
                .price(req.getPrice())
                .build();
        postRepository.save(mPost);

        return ("수정 성공");
    }

    public String modifyIsComplete(ModifyIsCompleteRequestDTO req) {
        Post mPost = Post.builder()
                .postId(req.getPostId())
                .isComplete(req.getIsComplete())
                .build();
        postRepository.save(mPost);

        return ("변경 완료");
    }

    public String removePost(long postId) {
        //  Post post = postRepository.findByIdAndIsDeleteFalse(postId).orElseThrow();

        Post rPost = Post.builder()
                .isDelete(true)
                .build();
        postRepository.save(rPost);

        return ("삭제 성공");
    }
}
