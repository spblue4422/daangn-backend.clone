package com.spblue4422.daangnclone.DTO.Common;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
public class BasicResponseDTO {
    private int status;
    private String message;
    private long id;

    public BasicResponseDTO(int sts, String msg, long id) {
        this.status = sts;
        this.message = msg;
        this.id = id;
    }
}
