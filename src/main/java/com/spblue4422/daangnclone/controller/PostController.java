package com.spblue4422.daangnclone.controller;

import com.spblue4422.daangnclone.DTO.Common.BasicResponseDTO;
import com.spblue4422.daangnclone.DTO.Post.AddPostRequestDTO;
import com.spblue4422.daangnclone.DTO.Post.ModifyIsCompleteRequestDTO;
import com.spblue4422.daangnclone.DTO.Post.ModifyPostRequestDTO;
import com.spblue4422.daangnclone.model.entity.*;
import com.spblue4422.daangnclone.DTO.Post.*;
import com.spblue4422.daangnclone.DTO.User.UserSessionDTO;
import com.spblue4422.daangnclone.repository.PostRepository;
import com.spblue4422.daangnclone.service.InterestService;
import com.spblue4422.daangnclone.service.PhotoService;
import com.spblue4422.daangnclone.service.PostService;
import com.spblue4422.daangnclone.service.UserService;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final UserService userService;
    private final PostService postService;
    private final InterestService interestService;
    private final PhotoService photoService;

    //post정보만 뽑아오는게 아니라 사진도 뽑아와야하고, 관심등록 여부도 확인해야함.

    @GetMapping("/{postId}/detail")
    public Post getPostDetail(@PathVariable long postId, HttpServletRequest httpServletRequest) {
        try {
            HttpSession httpSession = httpServletRequest.getSession();
            UserSessionDTO dto = (UserSessionDTO) httpSession.getAttribute("user");
            Post post = postService.getOnePost(postId);

            if(dto == null) {
                //로그인 안되어 있음.
            } else {
                Interest interest = interestService.getOneByUserIdAndPostId(dto.getUserId(), postId);
                if(interest == null) {
                    //관심등록 안되어 있음.
                }
                else {
                    //되어 있음.
                }
            }
            // 사진정보 불러와야함.
            List<Photo> photoList = photoService.getAllPhotosByPostId(postId);

            // res에 있는 정보를 통해 유저랑 카테고리 정보 불러오기
            return post;
        } catch(Exception ex) {
            return null;
        }
    }

    @PostMapping("/posts")
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

            //DTO로 바꿔서 전달하는게 더 나을듯?
            return postList;
        } catch(Exception ex) {
            return null;
        }
    }

    @GetMapping("/myPosts/{userId}")
    public List<Post> getMyPostList(@PathVariable long userId, HttpServletRequest httpServletRequest) {
        try {
            HttpSession httpSession = httpServletRequest.getSession();
            UserSessionDTO dto = (UserSessionDTO) httpSession.getAttribute("user");
            if(dto.getUserId() != userId) {
                return null;
            }

            List<Post> postList = postService.getAllPostsByUserId(userId);

            return postList;
        } catch(Exception ex) {
            return null;
        }
    }

    @GetMapping("/myInterests/{userId}")
    public List<Post> getMyInterestList(@PathVariable long userId, HttpServletRequest httpServletRequest) {
        try {
            HttpSession httpSession = httpServletRequest.getSession();
            UserSessionDTO dto = (UserSessionDTO)httpSession.getAttribute("user");

            if(dto.getUserId() != userId) {
                return null; //로그인된 사람의 정보가 아닐때
            }

            List<Long> postIdList = interestService.getAllPostIdsByUserId(userId);
            List<Post> postList = postService.getAllPostsInPostIds(postIdList);

            return postList;
            //여기서 interest에 들어가있는 postId랑 조인된 post들 목록을 쭉 뽑아야함.
        }
        catch(Exception ex) {
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
            User currentUser = userService.getOneUser(dto.getUserId());
            Category category = postService.getPostCategory(req.getCategoryId());
            BasicResponseDTO res = postService.addPost(req, currentUser, category);

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
            Post post = postService.getOnePost(postId);
            
            if(dto == null || post.getUser().getUserId() == dto.getUserId()) {
                //로그인이 안되어 있거나, 본인이 쓴 게시글일때
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
            Post res = postService.getOnePost(req.getPostId());
            Category category = postService.getPostCategory(req.getCategoryId());

            //로그인이 안되어 있거나, 잘못된 로그인 정보거나 분리해야하나.
            if(dto == null || dto.getUserId() != res.getUser().getUserId()) {
                throw new Exception();
            }

            return postService.modifyPost(req, category);
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
            Post res = postService.getOnePost(req.getPostId());

            //로그인이 안되어 있거나, 잘못된 로그인 정보거나 분리해야하나.
            if(dto == null || dto.getUserId() != res.getUser().getUserId()) {
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