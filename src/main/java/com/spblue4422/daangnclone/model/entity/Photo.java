package com.spblue4422.daangnclone.model.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@Entity(name = "tb_photo")
public class Photo {
    @Id
    @Column(name = "Photo_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne()
    @JoinColumn(name = "Post_ID")
    private long postId;

    @Column(nullable = false)
    private String photo;

    //순서는 넣은 시간순으로 뽑으면 되지 않을까.
    @Column(nullable = false)
    private Date Reg_dt;
}
