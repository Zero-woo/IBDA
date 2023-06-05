package EL.IBDA.controller;

import EL.IBDA.domain.Member;
import EL.IBDA.dto.MemberDto;
import EL.IBDA.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "회원 API")
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "모든 회원 조회",description = "모든 회원 조회하기")
    @GetMapping("/members")
    public List<Member> list() {
        List<Member> members = memberService.findMembers();
        return members;
    }

//    @Operation(summary = "닉네임, 이메일, 주소만 조회")
//    @GetMapping("/members2")
//    public List<MemberDto> list2() {
//        List<Member> members = memberService.findMembers();
//        List<MemberDto> result = members.stream()
//                .map(o -> new MemberDto(o))
//                .collect(Collectors.toList());
//        return result;
//    }

    @Operation(summary = "회원 조회",description = "이메일로 회원 조회하기")
    @Parameter(name="email",description = "이메일",example = "IBDA@naver.com")
    @GetMapping("/member/{memberEmail}")
    public Member findMember(@PathVariable("memberEmail") String memberEmail) {
        Member member = memberService.findMemberByEmail(memberEmail);
        return member;
    }

    @Operation(summary = "회원 생성",description = "회원 생성하기")
    @PostMapping("/member/new")
    public void create(@RequestBody @Valid Member member) {
        memberService.saveMember(member);
    }

    @Operation(summary = "회원 삭제", description = "이메일로 회원 삭제하기")
    @Parameter(name="memberEmail", description = "이메일")
    @DeleteMapping("/member/{memberEmail}")
    public void deleteMember(@PathVariable("memberEmail") @Valid String memberEmail) {
        memberService.deleteMember(memberEmail);
    }

//    @Operation(summary = "이메일 변경", description = "이메일 변경하기")
//    @PostMapping("/member/{memberEmail}")
//    public void changeEmail(@PathVariable("memberEmail") String memberEmail){
//        memberService.changeEmail(memberEmail);
//    }

}
