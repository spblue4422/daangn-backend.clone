package com.spblue4422.daangnclone.service;

import com.spblue4422.daangnclone.model.entity.Interest;
import com.spblue4422.daangnclone.repository.InterestRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InterestService {
    private final InterestRepository interestRepository;

    public List<Interest> getAllInterestsByPostId(long postId) {
        return interestRepository.findAllByPostId(postId);
    }

    public List<Interest> getAllInterestsByUserId(long userId) {
        return interestRepository.findAllByUserId(userId);
    }

    //등록과 해제를 하나의 함수로 합치면 더 깔끔하지않을까
    public String addInterest(long userId, long postId) {

        final Interest aInterest = Interest.builder()
                .userId(userId)
                .postId(postId)
                .build();
        interestRepository.save(aInterest);

        return ("관심등록 완료");
    }

    //디비삭제
    public String removeInterest(long interestId) {
        interestRepository.deleteById(interestId);
        return ("관심등록 해제");
    }
}
