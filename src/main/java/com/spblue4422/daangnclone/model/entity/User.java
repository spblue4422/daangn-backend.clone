package com.spblue4422.daangnclone.model.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@Entity(name="TB_User")
public class User {
    @Id
    @Column(name = "User_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uid;

    @Column(nullable = false, unique = true, length = 30)
    private String email;

    //이메일 인증 여부

    @Column(nullable = false)
    private String password;

    @Column(nullable=false, length = 20)
    private String name;

    @Column(nullable = false, unique=true, length = 40)
    private String nickName;

    @Column(nullable = false, length = 15)
    private String phone;

    @Column(nullable = false)
    private String region;

    //지역 인증 여부
    //지역 인증 받은 날짜

    //프로필 사진 저장경로
    @Column(nullable = true)
    private String profile;

    //뱃지 목록 배열
    //평가수치

    @Column(nullable=false)
    private Date Reg_dt;

    @Column(nullable = false)
    private Boolean isDelete;

    public User(String email, String password, String name, String nickName, String phone, String region, String profile) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickName = nickName;
        this.phone = phone;
        this.region = region;
        this.profile = profile;
        this.Reg_dt = new Date();
        this.isDelete = false;
    }
}
