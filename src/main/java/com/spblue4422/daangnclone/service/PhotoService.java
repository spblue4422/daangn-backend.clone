package com.spblue4422.daangnclone.service;

import com.spblue4422.daangnclone.model.entity.Photo;
import com.spblue4422.daangnclone.repository.PhotoRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoService {
    private final PhotoRepository photoRepository;

    //photo의 리스트 말고 vo(dto)로 추출해서 줘도 되지않을까
    public List<Photo> getAllPhotosByPostId(long postId) {
        return photoRepository.getAllPhotosByPostId(postId);
    }

    public void addPhotots() {

    }

    public void deletePhotos() {
        
    }
}
