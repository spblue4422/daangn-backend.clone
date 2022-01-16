package com.spblue4422.daangnclone.DTO.User;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
public class BriefUserInfoResponseDTO {
    private String nickName;
    private String profile;
    // 매너수치? 같은것들 추가하면 여기에 넣어줘야함.

    public BriefUserInfoResponseDTO(String nickName, String profile) {
        this.nickName = nickName;
        this.profile = profile;
    }
}
