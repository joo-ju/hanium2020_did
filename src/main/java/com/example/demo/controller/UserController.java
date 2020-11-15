package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("userSession")
public class UserController {

    @Autowired
    private UserService userService;

    User user;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("currentLogin")
    public CurrentLogin loginData(){return new CurrentLogin(); }

    @RequestMapping("/login")
    public String handleRequest(HttpServletRequest request,
                                      @ModelAttribute("currentLogin") CurrentLogin loginData, Model model ) {
        System.out.println(loginData.getUserId() + "//" + loginData.getPassword());
        User user = userService.findByUserIdAndUserPassword(loginData.getUserId(), loginData.getPassword());
        if (user == null)
            return "/login";
        if (loginData.getPassword().equals(user.getUserPassword())) {
            UserSession userSession = new UserSession(user, loginData().getUserId());
            model.addAttribute("userSession", userSession);
            return "/index";
        } else
           return "/login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session, SessionStatus sessionStatus){
        session.removeAttribute("userSession");
        sessionStatus.setComplete();
        return "/index";
    }


}
