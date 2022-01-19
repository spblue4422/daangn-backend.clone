package com.spblue4422.daangnclone.repository;

import com.spblue4422.daangnclone.model.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //List<User> findAll();
    Optional<User> findByEmailAndIsDeleteFalse(String email);
    Optional<User> findByNickNameAndIsDeleteFalse(String nickName);
    Optional<User> findByUserIdAndIsDeleteFalse(long userId);
}
