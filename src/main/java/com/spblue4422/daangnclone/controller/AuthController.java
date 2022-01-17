package com.spblue4422.daangnclone.controller;

import com.spblue4422.daangnclone.model.entity.User;
import com.spblue4422.daangnclone.DTO.User.*;
import com.spblue4422.daangnclone.repository.UserRepository;
import com.spblue4422.daangnclone.service.UserService;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.util.Arrays;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    final UserService userService;
    //로그인 기능
    @PostMapping("/login")
    public String userLogin(@RequestBody UserLoginRequestDTO req, HttpSession httpSession) {
        try {
            User user = userService.getOneUserByEmail(req.getEmail());
            if(user == null) {
                //throw exception 해도됨.
                return ("잘못된 아이디입니다.");
            }
            else if(!Arrays.equals(req.getPassword(), user.getPassword())) {
                return ("잘못된 비밀번호 입니다.");
            }
            httpSession.setAttribute("user", new UserSessionDTO(user.getUid(), user.getEmail()));
            return("로그인 성공");
        }
        catch(Exception ex) {
            return("asd");
        }
    }

    //로그아웃
    @GetMapping("/logout")
    public String userLogout(HttpServletRequest req) {
        try {
            HttpSession httpSession = req.getSession();
            httpSession.invalidate();
            return ("로그아웃");
        }
        catch(Exception ex) {
            return("error");
        }
    }

    // 아이디 중복확인
    @PostMapping("/doubleCheck/userId")
    public void doubleCheckEmail(@RequestBody String email) {
        try {
            if(userService.getOneUserByEmail(email) != null) {

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
}
