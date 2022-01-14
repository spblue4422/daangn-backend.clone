package com.spblue4422.daangnclone.model.DTO;

import com.spblue4422.daangnclone.model.entity.User;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
public class BriefUserResponseDTO {
    private String nickName;
    private String profile;
    // 매너수치? 같은것들 추가하면 여기에 넣어줘야함.

    public BriefUserResponseDTO(String nickName, String profile) {
        this.nickName = nickName;
        this.profile = profile;
    }
}
