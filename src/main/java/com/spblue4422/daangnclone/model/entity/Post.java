package com.spblue4422.daangnclone.model.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@Entity(name = "TB_Post")
public class Post {
    @Id
    @Column(name = "Post_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pid;

    @ManyToOne
    @JoinColumn(name = "User_ID")
    private long userId;

    @ManyToOne
    @JoinColumn(name="Category_ID")
    private long categoryId;

    @Column(nullable = false)
    private String title;

    //장소는 user랑 조인해서 불러올수 있지 않나

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int like;

    @Column(nullable = false)
    private int isComplete;

    @Column(nullable = false)
    private Date Reg_dt;

    @Column(nullable = false)
    private Boolean isDelete;

    public Post(long userId, long categoryId, String title, String content, int price) {
        this.userId = userId;
        this.categoryId = categoryId;
        this.title = title;
        this.content = content;
        this.price = price;
        this.like = 0;
        this.isComplete = 0;
        this.Reg_dt = new Date();
        this.isDelete = false;
    }
}
