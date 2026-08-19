package com.example.blog.dto.request;

import lombok.Getter;
// 포스트맨에서 보낸 데이터 받음

@Getter
public class CreateMemberRequest {
    private String name;
    private String loginId;
    private String password;
}
