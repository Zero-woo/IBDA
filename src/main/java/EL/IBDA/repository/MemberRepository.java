package EL.IBDA.repository;

import EL.IBDA.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    <S extends Member> S save(S entity);

    void delete(Member member);

    List<Member> findAll();

    Optional<Member> findByEmail(String id);

}
