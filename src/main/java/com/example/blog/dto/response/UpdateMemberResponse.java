package com.example.blog.dto.response;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Builder;

@Builder
public class UpdateMemberResponse {
    @Id
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;
}
