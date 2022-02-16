package com.spblue4422.daangnclone.repository;

import com.spblue4422.daangnclone.model.entity.Interest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Long> {

    List<Interest> findAllByPostId(long postId);

    List<Interest> findAllByUserId(long userId);

    @Query(value = "SELECT i.postID FROM Interest i where i.userId = :userId", nativeQuery = true)
    List<Long> findPostIdsByUserId(@Param("userId") long userId);

    Optional<Interest> findByUserIdAndPostId(long userId, long postId);
}
