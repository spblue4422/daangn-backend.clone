package com.spblue4422.daangnclone.model.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import com.spblue4422.daangnclone.common.DateFormatter;

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
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name="categoryId")
    private Category category;

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
    private String Reg_dt;

    @Column(nullable = false)
    private Boolean isDelete;

    public Post(String title, String content, int price) {
        this.title = title;
        this.content = content;
        this.price = price;
        this.like = 0;
        this.isComplete = 0;
        this.Reg_dt = DateFormatter.dtFormat(new Date());
        this.isDelete = false;
    }
}
