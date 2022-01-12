package com.spblue4422.daangnclone.model.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@Entity(name = "TB_Comment")
public class Comment {
    @Id
    @Column(name = "Comment_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cid;

    @ManyToOne
    @JoinColumn(name="User_ID")
    private long userId;

    @ManyToOne
    @JoinColumn(name = "Post_ID")
    private long postId;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int like;

    @Column(nullable = false)
    private Date Reg_dt;

    @Column(nullable = false)
    private Boolean isDelete;

    public Comment(long userId, long postId, String content) {
        this.userId = userId;
        this.postId = postId;
        this.content = content;
        this. like = 0;
        this.Reg_dt = new Date();
        this.isDelete = false;
    }
}
