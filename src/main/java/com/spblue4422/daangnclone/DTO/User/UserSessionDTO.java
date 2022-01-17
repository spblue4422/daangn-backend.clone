package com.spblue4422.daangnclone.DTO.User;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
public class UserSessionDTO {
    private long userId;
    private String email;

    public UserSessionDTO(long userId, String email) {
        this.userId = userId;
        this.email = email;
    }
}
