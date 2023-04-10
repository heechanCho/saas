package saas.tadpolehub.com.saas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import saas.tadpolehub.com.saas.service.MemberService;

@Controller
@RequestMapping(value = "/thymeleaf")
public class ThymeleafExController {



    @GetMapping(value = "/ex01")
    public String thymeleafExample01(Model model) {
        model.addAttribute("data", "welcom! saas");
        return "thymeleafEx/thymeleafEx01";
    }

    @GetMapping(value = "/ex07")
    public String thymeleafExample07(){
        return "thymeleafEx/thymeleafEx07";
    }

}
