package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("accountForm")
    public AccountForm registData() {return new AccountForm(); }

    @RequestMapping(method = RequestMethod.GET)
    public String showForm() {
        return "/sign_up";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(
            HttpServletRequest request, HttpSession session,
            @ModelAttribute("accountForm") AccountForm accountForm,
            BindingResult result) throws Exception {
            if (userService.findByUserId(accountForm.getUserId()) != null)
                return "/sign_up";
            else {
//                System.out.println("/////////////////////////////"+ userService.findByUserId(accountForm.getUserId()).getUserId());
                if (accountForm.getPassword().equals(accountForm.getCheckPassword())) {
                    User user = new User();
                    user.setUserId(accountForm.getUserId());
                    user.setUserName(accountForm.getName());
                    user.setUserPassword(accountForm.getPassword());
                    user.setUserBirth(accountForm.getBirth());
                    user.setUserGender(accountForm.getGender());
                    user.setUserPhone(accountForm.getPhone());
                    user.setUserAddress(accountForm.getAddress());
                    user.setUserEmail(accountForm.getEmail());
                    // group 뺘고 다 넣음
                    userService.save(user);
                    return "/index";
                } else
                    return "/sign_up";
            }
    }
}
