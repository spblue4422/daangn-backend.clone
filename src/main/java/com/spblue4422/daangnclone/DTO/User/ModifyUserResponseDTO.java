package com.spblue4422.daangnclone.DTO.User;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
public class ModifyUserResponseDTO {
    private int status;
    private String message;

    public ModifyUserResponseDTO(int sts, String msg) {
        this.status = sts;
        this.message = msg;
    }
}
