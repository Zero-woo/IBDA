package EL.IBDA.dto;

import EL.IBDA.domain.Member;
import lombok.Data;

@Data
public class MemberDto {

    private Long id;
    private String email;
    private String address;

    public MemberDto(Member member) {
        id = member.getId();
        email = member.getEmail();
        address = getAddress();
    }
}
