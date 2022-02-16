package com.spblue4422.daangnclone.service;

import com.spblue4422.daangnclone.DTO.Common.BasicResponseDTO;
import com.spblue4422.daangnclone.common.DateFormatter;
import com.spblue4422.daangnclone.model.entity.User;
import com.spblue4422.daangnclone.DTO.User.*;
import com.spblue4422.daangnclone.repository.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import lombok.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    //@Autowired
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getOneUser(long userId) {
        //return userRepository.findById(userId).orElseThrow();
        return userRepository.findById(userId).orElse(null);
    }

    public User getOneUserByEmail(String email) {
        return userRepository.findByEmailAndIsDeleteFalse(email).orElse(null);
    }

    public User getOneUserByNickName(String nickName) {
        return userRepository.findByNickNameAndIsDeleteFalse(nickName).orElse(null);
    }

    public BasicResponseDTO addUser(AddUserRequestDTO req, String ePassword) {
        //String에서 DTO로 바꾸기
        User aUser = User.builder()
                .email(req.getEmail())
                .name(req.getName())
                .nickName(req.getNickName())
                .password(ePassword)
                .phone(req.getPhone())
                .region(req.getRegion())
                .profile(req.getProfile())
                .Reg_dt(DateFormatter.dtFormat(new Date()))
                .isDelete(false)
                .build();
        User user = userRepository.save(aUser);

        return new BasicResponseDTO(1, "가입 성공", user.getUserId());
    }
    //그냥 String으로 반환하는것도 고려
    public BasicResponseDTO modifyUser(ModifyUserRequestDTO req) {
        //User user = userRepository.findByUserIdAndIsDeleteFalse(req.getUserId()).orElseThrow();
        User user = userRepository.findByUserIdAndIsDeleteFalse(req.getUserId()).orElse(null);

        User mUser = User.builder()
                .userId(req.getUserId())
                .nickName(req.getNickName())
                .phone(req.getPhone())
                .region(req.getRegion())
                .profile(req.getProfile())
                .build();
        userRepository.save(mUser);

        return new BasicResponseDTO(1, "수정 성공", mUser.getUserId());
    }

    //게시글, 댓글, 사진, 관심 수 다 삭제 해야할거임.
    public void deleteUser(long userId) {
        
    }
}
