package saas.tadpolehub.com.saas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import saas.tadpolehub.com.saas.entity.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByEmail(String email);

    List<Member> findAll();
}
