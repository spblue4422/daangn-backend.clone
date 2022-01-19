package com.spblue4422.daangnclone.DTO.User;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
public class UserLoginRequestDTO {
    private String email;
    private String password;

    public UserLoginRequestDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
