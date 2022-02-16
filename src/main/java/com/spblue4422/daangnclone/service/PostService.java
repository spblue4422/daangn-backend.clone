package com.spblue4422.daangnclone.service;


import com.spblue4422.daangnclone.DTO.Common.BasicResponseDTO;
import com.spblue4422.daangnclone.model.entity.Category;
import com.spblue4422.daangnclone.model.entity.Post;
import com.spblue4422.daangnclone.DTO.Post.*;
import com.spblue4422.daangnclone.model.entity.User;
import com.spblue4422.daangnclone.repository.CategoryRepository;
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
    private final CategoryRepository categoryRepository;

    public Category getPostCategory(int categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public List<Post> getAllPostsByIsComplete(int status) {
        return postRepository.findAllByIsCompleteAndIsDeleteFalse(status);
    }

    public List<Post> getAllPostsByUserId(long userId) {
        return postRepository.findAllByUserAndIsDeleteFalse(userId);
    }

    public List<Post> getAllPostsInPostIds(List<Long> postIds) {
        return postRepository.findByPostIdInAndIsDeleteFalse(postIds);
    }

    public Post getOnePost(long postId) {
        //return postRepository.findById(postId).orElseThrow();
        Post post =  postRepository.findByPostIdAndIsDeleteFalse(postId).orElse(null);

        return post;
    }

    public BasicResponseDTO addPost(AddPostRequestDTO req, User user, Category category) {
        Post aPost = Post.builder()
            .user(user)
            .category(category)
            .title(req.getTitle())
            .content(req.getContent())
            .price(req.getPrice())
            .build();
        Post post = postRepository.save(aPost);
        
        return new BasicResponseDTO(1, "등록 성공", post.getPostId());
    }

    public String modifyPost(ModifyPostRequestDTO req, Category category) {
        //Post post = postRepository.findByIdAndIsDeleteFalse(req.getPostId()).orElseThrow();

        Post mPost = Post.builder()
                .postId(req.getPostId())
                .category(category)
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
