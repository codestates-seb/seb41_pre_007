package com.pre007.server.member.controller;


import com.pre007.server.dtoUtils.MultiResponseDto;
import com.pre007.server.dtoUtils.SingleResponseDto;
import com.pre007.server.member.dto.MemberDto;
import com.pre007.server.member.entity.Member;
import com.pre007.server.member.mapper.MemberMapper;
import com.pre007.server.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/members")
@Validated
@Slf4j
public class MemberController {
    private MemberService memberService;
    private MemberMapper mapper;

    public MemberController(MemberService memberService, MemberMapper mapper) {
        this.memberService = memberService;
        this.mapper = mapper;
    }

    //TODO POST
    @PostMapping
    public ResponseEntity postMember(@RequestBody MemberDto.Post postRequest){
        Member memberForService = mapper.memberPostToMember(postRequest);
        Member memberForResponse = memberService.createMember(memberForService);
        MemberDto.Response response = mapper.memberToMemberResponse(memberForResponse);

        return new ResponseEntity(new SingleResponseDto<>(response), HttpStatus.CREATED);
    }

    //TODO PATCH
    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") long memberId,
                                      @RequestBody MemberDto.Patch patchRequest){
        patchRequest.setMemberId(memberId);
        Member memberForService = mapper.memberPatchToMember(patchRequest);
        Member memberForResponse = memberService.updateMember(memberForService);
        MemberDto.Response response = mapper.memberToMemberResponse(memberForResponse);

        return new ResponseEntity(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    //TODO GET ONE
    @GetMapping("/{member-id}")
    public ResponseEntity getOneMember(@PathVariable("member-id") long memberId){
        Member memberForResponse = memberService.findOneMember(memberId);
        MemberDto.Response response = mapper.memberToMemberResponse(memberForResponse);

        return new ResponseEntity(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    //TODO GET ALL
    @GetMapping
    public ResponseEntity getAllMembers(@Positive @RequestParam int page,
                                       @Positive @RequestParam int size){
        Page<Member> pageMember = memberService.findAllMembers(page-1, size);
        List<Member> memberListForResponse = pageMember.getContent();
        List<MemberDto.Response> responses = mapper.memberListToMemberResponseList(memberListForResponse);

        return new ResponseEntity(new MultiResponseDto<>(responses, pageMember), HttpStatus.OK);
    }

    //TODO DELETE ONE
    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteOneMember(@PathVariable("member-id") long memberId){
        memberService.deleteOneMember(memberId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    //TODO DELETE ALL
/*    @DeleteMapping
    public ResponseEntity deleteAllMembers(){
        memberService.deleteAllMembers();

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }*/
}
