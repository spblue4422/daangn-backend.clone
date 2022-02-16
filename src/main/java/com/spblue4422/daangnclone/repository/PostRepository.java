package com.spblue4422.daangnclone.repository;

import com.spblue4422.daangnclone.DTO.Post.PostResponseDTO;
import com.spblue4422.daangnclone.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

    //@Query(value = "SELECT p.*, u.nickName, g.name as categoryName FROM Post p left join p.userId u left join p.categoryId g WHERE p.isComplete=(:status) AND p.isDelete = false", nativeQuery = true)
    List<Post> findAllByIsCompleteAndIsDeleteFalse(int status);

    //@Query(value = "SELECT p.*, u.nickName, g.name as categoryName FROM Post p left join p.userId u left join p.categoryId g WHERE p.userId=(:userId) AND p.isDelete = false", nativeQuery = true)
    List<Post> findAllByUserAndIsDeleteFalse(long userId);

    //@Query(value = "SELECT p.*, u.nickName as nickName, g.name as categoryName FROM tb_post p left join tb_user u on p.userId = u.userId left join tb_category g on p.categoryId = g.categoryId WHERE p.postId = (:postId)", nativeQuery = true)
    Optional<Post> findByPostIdAndIsDeleteFalse(long postId);

    //fetch 생각은 해야함.
    //@Query(value = "SELECT p.*, u.nickName, g.name as categoryName FROM tb_post p left join tb_user u on p.userId = u.userId left join tb_category g on p.categoryId = g.categoryId WHERE p.postId IN (:postIds)", nativeQuery = true)
    List<Post> findByPostIdInAndIsDeleteFalse(List<Long> postIds);
}
