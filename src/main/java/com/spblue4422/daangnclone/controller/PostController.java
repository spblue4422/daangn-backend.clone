package com.spblue4422.daangnclone.controller;

import com.spblue4422.daangnclone.DTO.Common.BasicResponseDTO;
import com.spblue4422.daangnclone.DTO.Post.AddPostRequestDTO;
import com.spblue4422.daangnclone.DTO.Post.ModifyIsCompleteRequestDTO;
import com.spblue4422.daangnclone.DTO.Post.ModifyPostRequestDTO;
import com.spblue4422.daangnclone.model.entity.Interest;
import com.spblue4422.daangnclone.model.entity.Post;
import com.spblue4422.daangnclone.DTO.Post.*;
import com.spblue4422.daangnclone.DTO.User.UserSessionDTO;
import com.spblue4422.daangnclone.repository.PostRepository;
import com.spblue4422.daangnclone.service.InterestService;
import com.spblue4422.daangnclone.service.PostService;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private PostService postService;
    private InterestService interestService;

    //post정보만 뽑아오는게 아니라 사진도 뽑아와야하고, 관심등록 여부도 확인해야함.
    @GetMapping("/{postId}/detail")
    public Post getPostDetail(@PathVariable long postId) {
        try {
            Post post = postService.getOnePost(postId);

            return post;
        } catch(Exception ex) {
            return null;
        }
    }

    public List<Post> getPostList(@RequestBody Map<String, Integer> req) {
        try {
            int status = req.get("isComplete");
            List<Post> postList;
            if(status < 0) { //-10000
                //전체 목록 조회
                 postList = postService.getAllPosts();
            }
            else {
                //특정 상태의 게시물만 조회
                postList = postService.getAllPostsByIsComplete(status);
            }

            return postList;
        } catch(Exception ex) {
            return null;
        }
    }

    public List<Post> getMyPostList(@RequestBody Map<String, Long> req) {
        try {
            long userId = req.get("userId");
            List<Post> postList = postService.getAllPostsByUserId(userId);

            return postList;
        } catch(Exception ex) {
            return null;
        }
    }

    //사진등록 생각해야함.
    public String addPost(@RequestBody AddPostRequestDTO req, HttpServletRequest httpServletRequest){
        try {
            HttpSession httpSession = httpServletRequest.getSession();
            UserSessionDTO dto = (UserSessionDTO) httpSession.getAttribute("user");
            if(dto == null) {
                //로그인 안됨.
                throw new Exception();
            }

            Post post = postService.addPost(req, dto.getUserId());

            return ("성공");
        }
        catch(Exception ex) {
            return null;
        }
    }

    @GetMapping("/{postId}/interest")
    public String pushPostInterest(@PathVariable long postId, HttpServletRequest httpServletRequest) {
        try {
            HttpSession httpSession = httpServletRequest.getSession();
            UserSessionDTO dto = (UserSessionDTO) httpSession.getAttribute("user");
            if(dto == null) {
                throw new Exception();
            }

            Interest interest = interestService.getOneByUserIdAndPostId(dto.getUserId(), postId);
            if(interest == null) {
                BasicResponseDTO res = interestService.addInterest(dto.getUserId(), postId);
            } else {
                BasicResponseDTO res = interestService.removeInterest(interest.getInterestId());
            }
            return("성공");
        }
        catch(Exception ex) {
            return null;
        }
    }

    //게시글 내용 수정
    public String modifyPost(@RequestBody ModifyPostRequestDTO req, HttpServletRequest httpServletRequest) {
        try {
            HttpSession httpSession = httpServletRequest.getSession();
            UserSessionDTO dto = (UserSessionDTO) httpSession.getAttribute("user");
            Post post = postService.getOnePost(req.getPostId());

            //로그인이 안되어 있거나, 잘못된 로그인 정보거나 분리해야하나.
            if(dto == null || dto.getUserId() != post.getUserId()) {
                throw new Exception();
            }

            return postService.modifyPost(req);
        }
        catch(Exception ex) {
            return null;
        }
    }

    //거래완료 수정
    public String modifyPostIsComplete(@RequestBody ModifyIsCompleteRequestDTO req, HttpServletRequest httpServletRequest) {
        try {
            HttpSession httpSession = httpServletRequest.getSession();
            UserSessionDTO dto = (UserSessionDTO) httpSession.getAttribute("user");
            Post post = postService.getOnePost(req.getPostId());

            //로그인이 안되어 있거나, 잘못된 로그인 정보거나 분리해야하나.
            if(dto == null || dto.getUserId() != post.getUserId()) {
                throw new Exception();
            }

            return postService.modifyIsComplete(req);
        }
        catch(Exception ex) {
            return null;
        }
    }

    public void removePost(long postId) {

    }
}