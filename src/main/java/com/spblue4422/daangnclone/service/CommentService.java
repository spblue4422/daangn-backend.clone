package com.spblue4422.daangnclone.service;

import com.spblue4422.daangnclone.common.DateFormatter;
import com.spblue4422.daangnclone.model.entity.Comment;
import com.spblue4422.daangnclone.repository.CommentRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.*;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment getOneCommentById(long commentId) {
        //return commentRepository.findById(commentId).orElseThrow();
        return commentRepository.findById(commentId).orElse(null);
    }

    public List<Comment> getAllCommentsByPostId(long postId) {
        return commentRepository.findAllByPostIdAndIsDeleteFalse(postId);
    }

    //return으로 dto를 넘기는것도 생각해봐야함.
    public Comment addComment(long userId, long postId, String content) {
        Comment aComment = Comment.builder()
            .userId(userId)
            .postId(postId)
            .content(content)
            .build();
        return commentRepository.save(aComment);
    }

    //댓글 좋아요는 나중에.

    public String modifyComment(long commentId, String content) {
        //comment 수정 방법 찾자
        //예외 throw
        //Comment comment = commentRepository.findByIdAndIsDeleteFalse(commentId).orElseThrow();

        //수정이 잘 될지는 확인해 봐야할듯
        Comment mComment = Comment.builder()
                .commentId(commentId)
                .content(content)
                .build();
        commentRepository.save(mComment);

        return ("수정");
    }

    public String removeComment(long commentId) {
        //Comment rComment = commentRepository.findByIdAndIsDeleteFalse(commentId).orElseThrow();

        Comment rComment = Comment.builder()
                .commentId(commentId)
                .isDelete(true)
                .build();
        commentRepository.save(rComment);

        return ("삭제 처리");
    }
}
