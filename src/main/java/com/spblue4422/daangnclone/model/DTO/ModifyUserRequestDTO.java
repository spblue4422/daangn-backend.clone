package com.spblue4422.daangnclone.model.DTO;

import com.spblue4422.daangnclone.model.entity.User;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
public class ModifyUserRequestDTO {
    private long userId;
    private String nickName;
    private String phone;
    private String region;
    private String profile;

    public ModifyUserRequestDTO (long userId, String nickName, String phone, String region, String profile) {
        this.userId = userId;
        this.nickName = nickName;
        this.phone = phone;
        this.region = region;
        this.profile = profile;
    }
}
