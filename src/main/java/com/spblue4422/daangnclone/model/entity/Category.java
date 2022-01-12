package com.spblue4422.daangnclone.model.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@Entity(name = "TB_Category")
public class Category {
    @Id
    @Column(name = "Category_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 25)
    private String name;

    public Category(String name) {
        this.name = name;
    }
}
