package com.spblue4422.daangnclone.repository;

import com.spblue4422.daangnclone.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
    List<Post> findAllByIsCompleteAndIsDeleteFalse(int status);
    List<Post> findAllByUserIdAndIsDeleteFalse(long userId);
    Optional<Post> findByIdAndIsDeleteFalse(long postId);
}
