package com.spblue4422.daangnclone.controller;

import com.spblue4422.daangnclone.model.entity.Post;
import com.spblue4422.daangnclone.DTO.Post.*;
import com.spblue4422.daangnclone.repository.PostRepository;
import com.spblue4422.daangnclone.service.PostService;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    final PostService postService;

    //post정보만 뽑아오는게 아니라 사진도 뽑아와야하고, 관심등록 여부도 확인해야함.
    public void getPostDetail(long postId) {

    }

    public void getPostList() {

    }

    public void getMyPostList(long userId) {

    }

    //사진등록 생각해야함.
    public void addPost(){

    }

    public void pushPostInterest(long postId) {

    }

    //게시글 내용 수정
    public void modifyPost() {

    }

    //거래완료 수정
    public void modifyPostIsComplete(long postId) {

    }

    public void removePost(long postId) {

    }
}