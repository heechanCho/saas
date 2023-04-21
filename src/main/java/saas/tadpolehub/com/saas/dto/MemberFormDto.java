package saas.tadpolehub.com.saas.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import saas.tadpolehub.com.saas.entity.Member;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MemberFormDto {

    // 이름
    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String name;

    // 이메일
    @NotEmpty(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String email;

    // 비밀번호
    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min = 8, max = 16, message = "비밀번호는 8자 이상, 16자 이하로 입력해주세요")
    private String password;

    // 비밀번호 재확인
    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String passwordCheck;

    @NotEmpty(message = "주소는 필수 입력 값입니다.")
    // 주소
    private String address;

    private String zipCode; // 우편번호

    private String detailAddress; // 상세주소

    private String village; // 참고항목

    // 회사이름
    private String companyName;

    // 회사이름
    private String companyGroup;




}
