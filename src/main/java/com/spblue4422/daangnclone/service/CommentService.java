package com.spblue4422.daangnclone.service;

import com.spblue4422.daangnclone.model.entity.Comment;
import com.spblue4422.daangnclone.repository.CommentRepository;
import java.util.List;
import javax.transaction.Transactional;
import lombok.*;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public List<Comment> getAllCommentsByPostId(long postId) {
        return commentRepository.findAllByPostId(postId);
    }

    public Comment addComment(long userId, long postId, String content) {
        final Comment comment = Comment.builder()
            .userId(userId)
            .postId(postId)
            .content(content)
            .build();
        return commentRepository.save(comment);
    }

    public String updateComment(long commentId, String content) {
        //comment 수정 방법 찾자
        Comment comment = commentRepository.getById(commentId);
        return ("수정");
    }
}
