package com.spblue4422.daangnclone.controller;

import com.spblue4422.daangnclone.model.entity.User;
import com.spblue4422.daangnclone.DTO.User.*;
import com.spblue4422.daangnclone.repository.UserRepository;
import com.spblue4422.daangnclone.service.UserService;
import lombok.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.*;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    //로그인 기능
    @PostMapping("/login")
    public String userLogin(@RequestBody UserLoginRequestDTO req, HttpSession httpSession) {
        try {
            String encodedPassword = passwordEncoder.encode(req.getPassword());
            User user = userService.getOneUserByEmail(req.getEmail());
            if(user == null) {
                //throw exception 해도됨.
                return ("잘못된 아이디입니다.");
            }
            else if(!Objects.equals(req.getPassword(), user.getPassword())) {
                return ("잘못된 비밀번호 입니다.");
            }
            httpSession.setAttribute("user", new UserSessionDTO(user.getUserId(), user.getEmail()));
            return("로그인 성공");
        }
        catch(Exception ex) {
            return null;
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
    public String doubleCheckEmail(@RequestBody String email) {
        try {
            if(userService.getOneUserByEmail(email) != null) {
                return("사용할 수 있는 이메일입니다.");
            }
            else {
                return("이미 등록되어 있는 이메일입니다.");
            }
        }
        catch(Exception ex) {
            return null;
        }
    }

    //유저 정보 추가(회원가입)
    //사진은 어떻게 할것인가...
    @PostMapping("/signUp")
    public String addUserInfo(@RequestBody AddUserRequestDTO req) {
        try {
            //이메일, 닉네임 중복확인 된 상태
            String encodedPassword = passwordEncoder.encode(req.getPassword());
            String ret = userService.addUser(req, encodedPassword);

            return ret;
            //return (req.getEmail() + " " + req.getNickName());
        }
        catch(Exception ex) {
            return (ex.getMessage());
        }
    }
}
