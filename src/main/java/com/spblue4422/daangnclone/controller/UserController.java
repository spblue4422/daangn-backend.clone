package com.spblue4422.daangnclone.controller;

import com.spblue4422.daangnclone.DTO.Common.BasicResponseDTO;
import com.spblue4422.daangnclone.model.entity.User;
import com.spblue4422.daangnclone.DTO.User.*;
import com.spblue4422.daangnclone.repository.UserRepository;
import com.spblue4422.daangnclone.service.UserService;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    //마이페이지
    @GetMapping("/myPage/:userId")
    public MyPageInfoResponseDTO getMyPageInfo(@RequestBody Map<String, Long> req, HttpServletRequest httpServletRequest) {
        try {
            //본인이 맞는지 확인.
            long userId = req.get("userId");
            HttpSession httpSession = httpServletRequest.getSession();
            UserSessionDTO dto = (UserSessionDTO) httpSession.getAttribute("user");
            if(dto.getUserId() != userId) {
                //로그인된 유저정보랑 다른 유저
                return null;
            }


            User user = userService.getOneUser(userId);
            return new MyPageInfoResponseDTO(user.getEmail(), user.getNickName(), user.getPhone(), user.getRegion(), user.getProfile());
        }
        catch(Exception ex) {
            return null;
        }
    }

    //다른 유저 정보 확인
    @GetMapping("/{userId}")
    public BriefUserInfoResponseDTO getOtherUserInfo(@PathVariable Long userId) {
        try {
            User user = userService.getOneUser(userId);
            if(user == null) {
                return new BriefUserInfoResponseDTO("사용자를 찾을 수 없음.", "abcd");
            }
            return new BriefUserInfoResponseDTO(user.getNickName(), user.getProfile());
        }
        catch(Exception ex) {
            return null;
        }
    }

    //닉네임 중복확인
    @PostMapping("/doubleCheck/nickName")
    public String doubleCheckNickName(@RequestBody Map<String, String> req) {
        try {
            //이미 사용중인경우
            String nickName = req.get("nickName");
            if(userService.getOneUserByNickName(nickName) != null) {
                return ("중복");
            }
            else {
                return("사용 가능");
            }
        }
        catch(Exception ex) {
            return (ex.getMessage());
        }
    }


    //유저 정보 수정
    @PostMapping("/modify/:userId")
    public String modifyUserInfo(@RequestBody ModifyUserRequestDTO req, HttpServletRequest httpServletRequest) {
        try {
            //로그인여부 확인 필요
            HttpSession httpSession = httpServletRequest.getSession();
            UserSessionDTO dto = (UserSessionDTO) httpSession.getAttribute("user");
            if(dto.getUserId() != req.getUserId()) {
                //로그인된 유저정보랑 다른 유저
                return null;
            }
            //유저 정보 수정
            BasicResponseDTO res = userService.modifyUser(req);
            //return res.getMessage();
            return ("성공");
        }
        catch(Exception ex) {
            return null;
        }
    }
}
