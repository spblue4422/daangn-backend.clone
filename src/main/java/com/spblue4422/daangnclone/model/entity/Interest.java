package com.spblue4422.daangnclone.model.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@Entity(name="TB_Interest")
public class Interest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "User_ID")
    private long userId;

    @ManyToOne
    @JoinColumn(name = "Post_ID")
    private long postId;

    @Column
    private Date Reg_dt;

    public Interest(long userId, long postId) {
        this.userId = userId;
        this.postId = postId;
        this.Reg_dt = new Date();
    }
}
