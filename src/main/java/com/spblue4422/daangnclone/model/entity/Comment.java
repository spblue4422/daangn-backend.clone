package com.spblue4422.daangnclone.model.entity;

import com.spblue4422.daangnclone.common.DateFormatter;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_comment")
@DynamicUpdate
public class Comment {
    @Id
    //@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="userId")
    private long userId;

    @ManyToOne(targetEntity = Post.class)
    @JoinColumn(name = "postId")
    private long postId;

    @Column(nullable = false, length = 500)
    private String content;

    @Column(nullable = false)
    private int like;

    @Column(nullable = false)
    private String Reg_dt;

    @Column(nullable = false)
    private Boolean isDelete;

    public Comment(long userId, long postId, String content) {
        this.userId = userId;
        this.postId = postId;
        this.content = content;
        this. like = 0;
        this.Reg_dt = DateFormatter.dtFormat(new Date());
        this.isDelete = false;
    }
}
