package saas.tadpolehub.com.saas.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberFormDto {

    // 이름
    private String name;

    // 이메일
    private String email;

    // 비밀번호
    private String password;

    // 비밀번호 재확인
    private String passwordCheck;

    // 주소
    private String address;

    // 회사이름
    private String companyName;

    // 회사이름
    private String companyGroup;



}
