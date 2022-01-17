package com.spblue4422.daangnclone.controller;

import com.spblue4422.daangnclone.model.entity.Comment;
import com.spblue4422.daangnclone.DTO.Comment.*;
import com.spblue4422.daangnclone.repository.CommentRepository;
import com.spblue4422.daangnclone.service.CommentService;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    final CommentService commentService;

    public /*List<CommentInfoResponseDTO>*/void getCommentList(long postId) {
        //이건 조인해서 넘겨주는게 더 나을것 같은디...
        //List<Comment> list = commentService.getAllCommentsByPostId(postId);
    }

    public void addComment() {

    }

    public void modifyComment(long commentId) {

    }

    public void likeComment(long commentId) {

    }

    public void removeComment(long commentId) {

    }
}
