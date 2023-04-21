package saas.tadpolehub.com.saas.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;
import saas.tadpolehub.com.saas.constant.Role;
import saas.tadpolehub.com.saas.dto.MemberFormDto;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String passwordCheck;

    private String zipCode; // 우편번호

    private String address;

    private String detailAddress; // 상세 주소

    private String village; // 참고 항목

    private String companyName;

    private String companyGroup;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
        Member member = new Member();
        member.setName(memberFormDto.getName());
        member.setEmail(memberFormDto.getEmail());
        member.setAddress(memberFormDto.getAddress());
        member.setZipCode(memberFormDto.getZipCode());
        member.setDetailAddress(memberFormDto.getDetailAddress());
        member.setVillage(memberFormDto.getVillage());
        member.setCompanyName(memberFormDto.getCompanyName());
        member.setCompanyGroup(memberFormDto.getCompanyGroup());
        String password = passwordEncoder.encode(memberFormDto.getPassword());
        String passwordCheck = passwordEncoder.encode(memberFormDto.getPasswordCheck());
        member.setPassword(password);
        member.setPasswordCheck(passwordCheck);
        member.setRole(Role.ADMIN);
        return member;
    }
}
