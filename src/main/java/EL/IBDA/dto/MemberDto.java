package EL.IBDA.dto;

import EL.IBDA.domain.Member;
import lombok.Data;

@Data
public class MemberDto {

    private String nickname;
    private String email;
    private String address;

    public MemberDto(Member member) {
        nickname = member.getNickname();
        email = member.getEmail();
        address = getAddress();
    }

}
