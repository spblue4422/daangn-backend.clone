package com.spblue4422.daangnclone.controller;

import com.spblue4422.daangnclone.model.entity.User;
import com.spblue4422.daangnclone.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("TB_User")
    public List<User> getAllUser() {
      return userRepository.findAll();
    }

    @PostMapping("TB_User")
    public User signUp() {
        final User user = User.builder().email("spblue4422@naver.com").name("유승은").nickName("spblue4422").password("12345").phone("01093478891").region("Seoul").profile(null).build();
        return userRepository.save(user);
    }
}
