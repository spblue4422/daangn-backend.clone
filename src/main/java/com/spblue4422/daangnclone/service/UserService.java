package com.spblue4422.daangnclone.service;

import com.spblue4422.daangnclone.model.entity.User;
import com.spblue4422.daangnclone.repository.UserRepository;
import java.util.List;
import lombok.*;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
//@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User addUser(String email, String name, String nickName, String password, String phone, String region, String prof) {
        final User user = User.builder()
            .email(email)
            .name(name)
            .nickName(nickName)
            .password(password)
            .phone(phone)
            .region(region)
            .profile(prof)
            .build();
        return userRepository.save(user);
    }
}
