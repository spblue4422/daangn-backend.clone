package com.spblue4422.daangnclone.model.entity;

import com.spblue4422.daangnclone.common.DateFormatter;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="tb_interest")
public class Interest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long interestId;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "userId")
    private long userId;

    @ManyToOne(targetEntity = Post.class)
    @JoinColumn(name = "postId")
    private long postId;

    @Column(nullable = false)
    private String Reg_dt;

    public Interest(long userId, long postId) {
        this.userId = userId;
        this.postId = postId;
        this.Reg_dt = DateFormatter.dtFormat(new Date());
    }
}
