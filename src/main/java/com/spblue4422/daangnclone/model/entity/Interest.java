package com.spblue4422.daangnclone.model.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@Entity(name="tb_interest")
public class Interest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long interestId;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_userid")
    private long userId;

    @ManyToOne(targetEntity = Post.class)
    @JoinColumn(name = "post_postid")
    private long postId;

    @Column
    private Date Reg_dt;

    public Interest(long userId, long postId) {
        this.userId = userId;
        this.postId = postId;
        this.Reg_dt = new Date();
    }
}
