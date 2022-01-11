package com.spblue4422.daangnclone.model.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@Entity(name="TB_User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uid;

    @Column(nullable = false, unique = true, length = 30)
    private String ID;

    //이메일 인증 여부

    @Column(nullable = false)
    private String PW;

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

    @Column(nullable=false)
    private Date Reg_dt;

    //프로필 사진
    //뱃지 목록 배열
    //평가수치

    public User(String ID, String PW, String name, String nickName, String phone, String region) {
        this.ID = ID;
        this.PW = PW;
        this.name = name;
        this.nickName = nickName;
        this.phone = phone;
        this.region = region;
    }
}
