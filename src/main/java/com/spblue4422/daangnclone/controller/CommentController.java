package com.spblue4422.daangnclone.controller;

import com.spblue4422.daangnclone.model.entity.Comment;
import com.spblue4422.daangnclone.repository.CommentRepository;
import com.spblue4422.daangnclone.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    final CommentService commentService;

    public void getCommentList(long postId) {

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
