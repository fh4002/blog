package com.example.blog.controller;

import com.example.blog.dto.request.CreateMemberRequest;
import com.example.blog.dto.request.MemberRequest;
import com.example.blog.dto.request.UpdateMemberRequest;
import com.example.blog.dto.response.MemberResponse;
import com.example.blog.dto.response.UpdateMemberResponse;
import com.example.blog.entity.Member;
import com.example.blog.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor

public class MemberController {

    private final MemberService memberService;

    @PostMapping()
    public ResponseEntity<Void> createMember(@RequestBody CreateMemberRequest request){
        memberService.createMember(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResponse> getMember(@PathVariable Long memberId){
        MemberResponse body = memberService.getMember(memberId);
        return ResponseEntity.ok(body);
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long memberId){
        memberService.deleteMember(memberId);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<UpdateMemberResponse> updateMember(@RequestBody UpdateMemberRequest request){
        UpdateMemberResponse body = memberService.updateMember(request);
        return ResponseEntity.ok(body);
    }

}
