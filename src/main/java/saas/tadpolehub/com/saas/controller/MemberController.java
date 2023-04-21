package saas.tadpolehub.com.saas.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import saas.tadpolehub.com.saas.dto.MemberFormDto;
import saas.tadpolehub.com.saas.entity.Member;
import saas.tadpolehub.com.saas.service.MemberService;

import javax.validation.Valid;

@RequestMapping("/members")
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping(value = "/new")
    public String memberForm(Model model) {
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "member/memberForm";
    }

//    @PostMapping(value = "/new")
//    public String memberForm(MemberFormDto memberFormDto) {
//
//        Member member = Member.createMember(memberFormDto, passwordEncoder);
//        memberService.saveMember(member);
//
//        return "redirect:/";
//
//    }



    @PostMapping(value = "/new")
    public String newMember(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "member/memberForm";
        }

        if(!memberFormDto.getPassword().equals(memberFormDto.getPasswordCheck())) {
            bindingResult.rejectValue("passwordCheck", "passwordInCorrect", "2개의 패스워드가 일치하지 않습니다.");
            return "member/memberForm";
        }

        try {
            Member member = Member.createMember(memberFormDto, passwordEncoder);
            memberService.saveMember(member);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", e.getMessage());
            return "member/memberForm";
        }

        return "redirect:/";
    }

    @GetMapping(value = "/login")
    public String loginMember() {
        return "/member/memberLoginForm";
    }

    @GetMapping(value = "/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요");
        return "/member/memberLoginForm";
    }

    @GetMapping(value = "/memberInfo")
    public String memberInfo(Model model) {
        MemberFormDto memberFormDto = new MemberFormDto();
        Member member = new Member();

        memberFormDto.setName(member.getName());
        memberFormDto.setEmail(member.getEmail());
        memberFormDto.setCompanyName(member.getCompanyName());
        memberFormDto.setCompanyGroup(member.getCompanyGroup());

        model.addAttribute("memberFormDto", memberFormDto);
        return "/member/memberInfoForm";
    }



}
