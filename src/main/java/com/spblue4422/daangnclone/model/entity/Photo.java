package com.spblue4422.daangnclone.model.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_photo")
public class Photo {
    @Id
    //@Column(name = "photoId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long photoId;

    @ManyToOne(targetEntity = Post.class)
    @JoinColumn(name = "postId")
    private long postId;

    @Column(nullable = false)
    private String photoName;

    @Column(nullable = false)
    private int size;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private byte[] data;

    //순서는 넣은 시간순으로 뽑으면 되지 않을까.
    @Column(nullable = false)
    private String Reg_dt;
}
