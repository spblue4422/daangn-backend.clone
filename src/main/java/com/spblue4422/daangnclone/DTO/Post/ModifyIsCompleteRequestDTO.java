package com.spblue4422.daangnclone.DTO.Post;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
public class ModifyIsCompleteRequestDTO {
    private long postId;
    private int isComplete;

    public ModifyIsCompleteRequestDTO(long postId, int isComplete) {
        this.postId = postId;
        this.isComplete = isComplete;
    }
}
