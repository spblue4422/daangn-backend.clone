//package com.spblue4422.daangnclone.controller;
//
//import com.spblue4422.daangnclone.DTO.Post.AddPostRequestDTO;
//import com.spblue4422.daangnclone.DTO.Post.ModifyIsCompleteRequestDTO;
//import com.spblue4422.daangnclone.DTO.Post.ModifyPostRequestDTO;
//import com.spblue4422.daangnclone.model.entity.Post;
////import com.spblue4422.daangnclone.DTO.Post.*;
//import com.spblue4422.daangnclone.DTO.User.UserSessionDTO;
//import com.spblue4422.daangnclone.repository.PostRepository;
//import com.spblue4422.daangnclone.service.PostService;
//import lombok.*;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.*;
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//public class PostController {
//    private PostService postService;
//
//    //post정보만 뽑아오는게 아니라 사진도 뽑아와야하고, 관심등록 여부도 확인해야함.
////    public void getPostDetail(long postId) {
////
////    }
//
////    public void getPostList() {
////
////    }
//
////    public void getMyPostList(long userId) {
////
////    }
//
//    //사진등록 생각해야함.
////    public String addPost(@RequestBody AddPostRequestDTO req, HttpServletRequest httpServletRequest){
////        try {
////            HttpSession httpSession = httpServletRequest.getSession();
////            UserSessionDTO dto = (UserSessionDTO) httpSession.getAttribute("user");
////            if(dto == null) {
////                //로그인 안됨.
////                throw new Exception();
////            }
////
////            Post post = postService.addPost(req, dto.getUserId());
////
////            return ("성공");
////        }
////        catch(Exception ex) {
////            return null;
////        }
////    }
//
////    public void pushPostInterest(long postId) {
////
////    }
//
//    //게시글 내용 수정
////    public String modifyPost(@RequestBody ModifyPostRequestDTO req, HttpServletRequest httpServletRequest) {
////        try {
////            HttpSession httpSession = httpServletRequest.getSession();
////            UserSessionDTO dto = (UserSessionDTO) httpSession.getAttribute("user");
////            Post post = postService.getOnePost(req.getPostId());
////
////            //로그인이 안되어 있거나, 잘못된 로그인 정보거나 분리해야하나.
////            if(dto == null || dto.getUserId() != post.getUserId()) {
////                throw new Exception();
////            }
////
////            return postService.modifyPost(req);
////        }
////        catch(Exception ex) {
////            return null;
////        }
////    }
//
//    //거래완료 수정
////    public String modifyPostIsComplete(@RequestBody ModifyIsCompleteRequestDTO req, HttpServletRequest httpServletRequest) {
////        try {
////            HttpSession httpSession = httpServletRequest.getSession();
////            UserSessionDTO dto = (UserSessionDTO) httpSession.getAttribute("user");
////            Post post = postService.getOnePost(req.getPostId());
////
////            //로그인이 안되어 있거나, 잘못된 로그인 정보거나 분리해야하나.
////            if(dto == null || dto.getUserId() != post.getUserId()) {
////                throw new Exception();
////            }
////
////            return postService.modifyIsComplete(req);
////        }
////        catch(Exception ex) {
////            return null;
////        }
////    }
//
////    public void removePost(long postId) {
////
////    }
//}