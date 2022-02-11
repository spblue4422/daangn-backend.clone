package com.spblue4422.daangnclone.service;

import com.spblue4422.daangnclone.DTO.Common.BasicResponseDTO;
import com.spblue4422.daangnclone.model.entity.Interest;
import com.spblue4422.daangnclone.repository.InterestRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.Basic;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InterestService {
    private final InterestRepository interestRepository;

    public Interest getOneByUserIdAndPostId(long userId, long postId) {
        return interestRepository.findByUserIdAndPostId(userId, postId).orElse(null);
    }

    public List<Interest> getAllInterestsByPostId(long postId) {
        return interestRepository.findAllByPostId(postId);
    }

    public List<Interest> getAllInterestsByUserId(long userId) {
        return interestRepository.findAllByUserId(userId);
    }

    //등록과 해제를 하나의 함수로 합치면 더 깔끔하지않을까
    public BasicResponseDTO addInterest(long userId, long postId) {

        Interest aInterest = Interest.builder()
                .userId(userId)
                .postId(postId)
                .build();
        interestRepository.save(aInterest);

        return new BasicResponseDTO(1, "성공");
    }

    //디비삭제
    public BasicResponseDTO removeInterest(long interestId) {
        interestRepository.deleteById(interestId);
        return new BasicResponseDTO(1, "성공");
    }
}
