package com.spblue4422.daangnclone.model.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_post")
@DynamicUpdate
public class Post {
    @Id
    //@Column(name = "postId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postId;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_userid")
    private long userId;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name="category_categoryid")
    private int categoryId;

    @Column(nullable = false, length = 100)
    private String title;

    //장소는 user랑 조인해서 불러올수 있지 않나

    @Column(nullable = false, length = 1000)
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

    public Post(long userId, int categoryId, String title, String content, int price) {
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
