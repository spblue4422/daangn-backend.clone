package com.spblue4422.daangnclone.service;

import com.spblue4422.daangnclone.model.entity.User;
import com.spblue4422.daangnclone.model.DTO.*;
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

    public User getUserByEmail(String email) {
            return userRepository.findByEmail(email).orElseThrow();
    }

    public String addUser(String email, String name, String nickName, String password, String phone, String region, String prof) {
        //String에서 DTO로 바꾸기
        //중복이메일 확인 로직 컨트롤러에서 따로만들기
        //if(userRepository.findByEmail(email) != null) {
//                return ("아이디 중복");
//            }

            final User aUser = User.builder()
                    .email(email)
                    .name(name)
                    .nickName(nickName)
                    .password(password)
                    .phone(phone)
                    .region(region)
                    .profile(prof)
                    .build();
            userRepository.save(aUser);

        return ("회원가입 성공");
    }

    public String modifyUser(ModifyUserRequestDTO data) {
        User user = userRepository.findByUserIdAndIsDeleteFalse(data.getUserId()).orElseThrow();

        final User mUser = User.builder()
                .nickName(data.getNickName())
                .phone(data.getPhone())
                .region(data.getRegion())
                .profile(data.getProfile())
                .build();
        userRepository.save(mUser);
        return ("수정 성공");
    }
    
    //회원탈퇴도 추가
}
