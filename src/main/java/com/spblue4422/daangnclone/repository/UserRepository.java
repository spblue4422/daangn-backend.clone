package com.spblue4422.daangnclone.repository;

import com.spblue4422.daangnclone.model.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
