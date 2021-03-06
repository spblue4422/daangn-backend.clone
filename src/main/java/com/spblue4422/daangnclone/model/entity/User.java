package com.spblue4422.daangnclone.model.entity;

import com.spblue4422.daangnclone.common.DateFormatter;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="tb_user")
@DynamicUpdate
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(nullable = false, unique = true)
    private String email;

    //이메일 인증 여부

    @Column(nullable = false)
    String password;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String nickName;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String region;

    //지역 인증 여부
    //지역 인증 받은 날짜
    //최대반경? 같은것도 있으려나 당근마켓에

    @Column()
    private String profile;

//    @Column()
//    private int profileSize;
//
//    @Column()
//    private String type;
//
//    @Column()
//    private byte[] profileData;

    //뱃지 목록 배열
    //평가수치

    @Column(nullable = false)
    private String Reg_dt;

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
        this.Reg_dt = DateFormatter.dtFormat(new Date());
        this.isDelete = false;
    }
}
