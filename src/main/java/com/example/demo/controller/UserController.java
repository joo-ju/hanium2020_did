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
                                      @ModelAttribute("CurrentLogin") CurrentLogin loginData, Model model ) {
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

    @RequestMapping("/loginout")
    public String logout(HttpSession session, SessionStatus sessionStatus){
        session.removeAttribute("userSession");
        sessionStatus.setComplete();
        return "/index";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showForm() {
        return "/sign_up";
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public String onSubmit(
//            HttpServletRequest request, HttpSession session,
//            @ModelAttribute("user") AccountForm accountForm,
//            BindingResult result) throws Exception {
//
//        UserSession userSession = new UserSession(
//                us.getUser(accountForm.getAccount().getUsername()));
//
//        session.setAttribute("userSession", userSession);
//        return successViewName;
//    }
}
