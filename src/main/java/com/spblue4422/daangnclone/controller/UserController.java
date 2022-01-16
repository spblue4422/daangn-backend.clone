package com.spblue4422.daangnclone.controller;

import com.spblue4422.daangnclone.model.entity.User;
import com.spblue4422.daangnclone.DTO.User.*;
import com.spblue4422.daangnclone.repository.UserRepository;
import com.spblue4422.daangnclone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    final UserService userService;

    //로그인 기능

    //마이페이지
    @GetMapping("/myPage/:userId")
    public MyPageInfoResponseDTO getMyPageInfo(@RequestBody long userId) {
        try {
            //본인이 맞는지 확인.


            User user = userService.getOneUser(userId);
            return new MyPageInfoResponseDTO(user.getEmail(), user.getNickName(), user.getPhone(), user.getRegion(), user.getProfile());
        }
        catch(Exception ex) {
            return null;
        }
    }

    //다른 유저 정보 확인
    @GetMapping("/:userId")
    public BriefUserInfoResponseDTO getOtherUserInfo(@RequestBody long userId) {
        try {
            User user = userService.getOneUser(userId);

            return new BriefUserInfoResponseDTO(user.getNickName(), user.getProfile());
        }
        catch(Exception ex) {
            return null;
        }
    }

    // 아이디 중복확인
    @PostMapping("/doubleCheck/userId")
    public void doubleCheckEmail(@RequestBody String email) {
        try {
            if(userService.getUserByEmail(email) != null) {

            }
            else {

            }
        }
        catch(Exception ex) {

        }
    }

    //닉네임 중복확인
    @PostMapping("/doubleCheck/nickName")
    public void doubleCheckNickName(@RequestBody String nickName) {
        try {
            //이미 사용중인경우
            if(userService.getUserByNickName(nickName) != null) {
                return;
            }
            else {

            }
        }
        catch(Exception ex) {

        }
    }
    //유저 정보 추가(회원가입)
    //사진은 어떻게 할것인가...
    @PostMapping("/signUp")
    public void addUserInfo(@RequestBody AddUserRequestDTO req) {
        try {
            String ret = userService.addUser(req);
        }
        catch(Exception ex) {

        }
    }

    //유저 정보 수정
    @PostMapping("/modify/:userId")
    public void modifyUserInfo(@RequestBody ModifyUserRequestDTO req) {
        try {
            //로그인여부 확인 필요
            ModifyUserResponseDTO res = userService.modifyUser(req);
            //return res.getMessage();
        }
        catch(Exception ex) {

        }
    }
}
