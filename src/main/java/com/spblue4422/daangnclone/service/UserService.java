package com.spblue4422.daangnclone.service;

import com.spblue4422.daangnclone.model.entity.User;
import com.spblue4422.daangnclone.DTO.User.*;
import com.spblue4422.daangnclone.repository.UserRepository;
import java.util.List;
import java.util.Optional;

import lombok.*;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
//@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getOneUser(long userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    public User getOneUserByEmail(String email) {
            return userRepository.findByEmailAndIsDeleteFalse(email).orElse(null);
    }

    public User getOneUserByNickName(String nickName) {
        return userRepository.findByNickNameAndIsDeleteFalse(nickName).orElse(null);
    }

    public String addUser(AddUserRequestDTO data) {
        //String에서 DTO로 바꾸기

        final User aUser = User.builder()
                .email(data.getEmail())
                .name(data.getName())
                .nickName(data.getNickName())
                .password(data.getPassword())
                .phone(data.getPhone())
                .region(data.getRegion())
                .profile(data.getProfile())
                .build();
        userRepository.save(aUser);

        return ("회원가입 성공");
    }
    //그냥 String으로 반환하는것도 고려
    public ModifyUserResponseDTO modifyUser(ModifyUserRequestDTO data) {
        User user = userRepository.findByUserIdAndIsDeleteFalse(data.getUserId()).orElseThrow();

        User mUser = User.builder()
                .nickName(data.getNickName())
                .phone(data.getPhone())
                .region(data.getRegion())
                .profile(data.getProfile())
                .build();
        userRepository.save(mUser);

        return new ModifyUserResponseDTO(1, "수정 성공");
        //return ("수정 성공");
    }
    
    //회원탈퇴도 추가
}
