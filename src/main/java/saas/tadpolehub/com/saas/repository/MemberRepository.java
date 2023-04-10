package saas.tadpolehub.com.saas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import saas.tadpolehub.com.saas.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByEmail(String email);
}
