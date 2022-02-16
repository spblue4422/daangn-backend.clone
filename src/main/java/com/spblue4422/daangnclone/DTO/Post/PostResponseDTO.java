package com.spblue4422.daangnclone.DTO.Post;

import com.spblue4422.daangnclone.model.entity.Post;
import lombok.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@NoArgsConstructor
public class PostResponseDTO {
    private long postId;
    private long userId;
    private int categoryId;
    private String title;
    private String content;
    private int price;
    private int like;
    private int isComplete;
    private String Reg_dt;
    private Boolean isDelete;
    private String nickName;
    private String categoryName;

    public PostResponseDTO (long pid, long uid, int ctgid, String ttl, String ctn, int price, int like, int isC, String dt, boolean isD, String nick, String ctgN) {
        this.postId = pid;
        this.userId = uid;
        this.categoryId = ctgid;
        this.title = ttl;
        this.content = ctn;
        this.price = price;
        this.like = like;
        this.isComplete = isC;
        this.Reg_dt = dt;
        this.isDelete = isD;
        this.nickName = nick;
        this.categoryName = ctgN;
    }
}
