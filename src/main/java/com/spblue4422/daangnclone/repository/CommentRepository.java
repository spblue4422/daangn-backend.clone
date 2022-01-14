package com.spblue4422.daangnclone.repository;

import com.spblue4422.daangnclone.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
    List<Comment> findAllByPostIdAndIsDeleteFalse(long postId);
    Optional<Comment> findByIdAndIsDeleteFalse(long commentId);
}
