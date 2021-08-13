package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dr")

public class DispatcherRedirect {
    @RequestMapping("/d")
    String dispatcher(Model model){
        model.addAttribute("result","dispatcher");
        return "/test";
    }
    @RequestMapping("/r")
    String redirect(Model model){
        model.addAttribute("result","redirect");
        //重定向到webapp下的index.jsp
        return "redirect:/index.jsp";
    }

}
