package com.spblue4422.daangnclone.DTO.Common;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
public class BasicResponseDTO {
    private int status;
    private String message;

    public BasicResponseDTO(int sts, String msg) {
        this.status = sts;
        this.message = msg;
    }
}
