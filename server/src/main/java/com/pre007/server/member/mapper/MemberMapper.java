package com.pre007.server.member.mapper;

import com.pre007.server.member.dto.MemberDto;
import com.pre007.server.member.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostToMember(MemberDto.Post postRequest);
    Member memberPatchToMember(MemberDto.Patch patchRequest);
    MemberDto.Response memberToMemberResponse(Member member);
    List<MemberDto.Response> memberListToMemberResponseList(List<Member> memberList);
}
