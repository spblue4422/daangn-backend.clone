package com.spblue4422.daangnclone.DTO.User;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
public class MyPageInfoResponseDTO {
    private String email;
    private String nickName;
    private String phone;
    private String region;
    private String profile;

    public MyPageInfoResponseDTO(String email, String nickName, String phone, String region, String prof) {
        this.email = email;
        this.nickName = nickName;
        this.phone = phone;
        this.region = region;
        this.profile = prof;
    }
}
