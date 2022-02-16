package com.spblue4422.daangnclone.repository;

import com.spblue4422.daangnclone.model.entity.Photo;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
    List<Photo> getAllPhotosByPostId(long postId);
}
