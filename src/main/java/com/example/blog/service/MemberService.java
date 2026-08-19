package com.example.blog.service;

import com.example.blog.dto.request.CreateMemberRequest;
import com.example.blog.dto.request.UpdateMemberRequest;
import com.example.blog.dto.response.MemberResponse;
import com.example.blog.dto.response.UpdateMemberResponse;
import com.example.blog.entity.Member;
import com.example.blog.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.InstanceManagerBindings;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void createMember(CreateMemberRequest request) {
        Optional<Member> existedMember = memberRepository.findByLoginId(request.getLoginId());

        if(existedMember.isPresent()){
            throw new IllegalArgumentException("중복된 로그인 ID입니다"); // new
        }

        Member newMember = Member.builder()
                .name(request.getName())
                .loginId(request.getLoginId())
                .password(request.getPassword())
                .build();

        memberRepository.save(newMember);

    }

    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }

    public UpdateMemberResponse updateMember(UpdateMemberRequest request) {
        Member member = memberRepository.findById(request.getId())
                        .orElseThrow( () -> new IllegalArgumentException
                                ("해당 id의 멤버를 찾을 수 없습니다"));
        member.updateMember(request.getName());

        return UpdateMemberResponse.builder()
                .id(member.getId())
                .name(member.getName())
                .build();
    }

    public MemberResponse getMember(Long memberId) {
        Optional<Member> opMember = memberRepository.findById(memberId);

        if(opMember.isEmpty()){
            throw new IllegalArgumentException("해당 id의 멤버를 찾을 수 없습니다"); // new
        }

        Member member = opMember.get();

        /*
        Member member = memberRepository.findById(memberId)
                .orElseThrow()(
                    () -> new IllegalAccessException("해당 id의 멤버를 찾을 수 없습니다");
                );
         */
        return MemberResponse.builder()
                .loginId(member.getLoginId())
                .name(member.getName())
                .build();
    }
}

