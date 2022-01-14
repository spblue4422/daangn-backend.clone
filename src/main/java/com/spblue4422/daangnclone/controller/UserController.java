package com.spblue4422.daangnclone.controller;

import com.spblue4422.daangnclone.model.entity.User;
import com.spblue4422.daangnclone.model.DTO.*;
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

    @GetMapping("/:userId")
    public BriefUserResponseDTO getUserInfo(long userId) {
        try {
            User user = userService.getOneUser(userId);

            return new BriefUserResponseDTO(user.getNickName(), user.getProfile());
        }
        catch(Exception ex) {
            return null;
        }
    }

    @PostMapping("/modify/:userId")
    public void modifyUserInfo(ModifyUserRequestDTO req) {
        try {

        }
        catch(Exception ex) {

        }
    }
}
