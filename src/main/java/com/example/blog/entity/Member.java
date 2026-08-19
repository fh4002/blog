package com.example.blog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id // pk
    @GeneratedValue
    private Long id;

    @Column(length = 30, unique = true, nullable = false)
    private String loginId;

    @Column(nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String name;

    public Member updateMember(String name){ // 수정 메서드
        this.name = name;
        return this;
    }

}
