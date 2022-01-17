package com.spblue4422.daangnclone.DTO.Comment;

import lombok.*;
import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
public class CommentInfoResponseDTO {
    private long commentId;
    private long userId;
    private String content;
    private int like;
    private Date Reg_dt;

    public CommentInfoResponseDTO(long commentId, long userId, String content, int like, Date Reg_dt) {
        this.commentId = commentId;
        this.userId = userId;
        this.content = content;
        this.like = like;
        this.Reg_dt = Reg_dt;
    }
}
