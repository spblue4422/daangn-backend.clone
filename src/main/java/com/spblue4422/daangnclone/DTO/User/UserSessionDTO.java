package com.spblue4422.daangnclone.DTO.User;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
public class UserSessionDTO {
    private long uid;
    private String email;

    public UserSessionDTO(long uid, String email) {
        this.uid = uid;
        this.email = email;
    }
}
