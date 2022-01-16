package com.spblue4422.daangnclone.DTO.User;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
public class AddUserRequestDTO {
    private String email;
    private String name;
    private String nickName;
    private String password;
    private String phone;
    private String region;
    private String profile;

    public AddUserRequestDTO(String email, String name, String nickName, String password, String phone, String region, String prof) {
        this.email = email;
        this.name = name;
        this.nickName = nickName;
        this.password = password;
        this.phone = phone;
        this.region = region;
        this.profile = prof;
    }
}
