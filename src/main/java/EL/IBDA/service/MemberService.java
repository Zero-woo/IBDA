package EL.IBDA.service;

import EL.IBDA.domain.Member;
import EL.IBDA.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void saveMember(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
    }

    @Transactional
    public void deleteMember(String email) {
        Member member = findMemberByEmail(email);
        memberRepository.delete(member);
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findMemberByEmail(String email) {
        Optional<Member> findMember = memberRepository.findByEmail(email);
        return findMember.orElseThrow(() -> new IllegalStateException("없는 회원입니다."));
    }

    public void validateDuplicateMember(Member member) {
        Optional<Member> findMember = memberRepository.findById(member.getId());
        findMember.ifPresent( m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    @Transactional
    public void changeEmail(String email) {
        Member member = findMemberByEmail(email);
        member.setEmail(email);
    }

}
