package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.DonateRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.DonateService;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/profile_edit")
    public String viewProfileEditPage() {

        return "profile_edit";
    }

    @RequestMapping("/profile_edit_")
    public String updateProfile( Model uiModel,  @RequestParam("updateUserAddress") String updateUserAddress){
        String userId = "U00001";
        User user = userRepository.findByUserId(userId);
        User e;
        user.setUserAddress(updateUserAddress);
        user.setGroup(user.getGroup());
        user.setUserBirth(user.getUserBirth());
        user.setUserEmail(user.getUserEmail());
        user.setUserGender(user.getUserGender());
        user.setUserInputdate(user.getUserInputdate());
        user.setUserName(user.getUserName());
        userService.save(user);
//        userRepository.save(user);

//        userService.updateByUserId(userId, updateUserAddress);
//        user.setUserAddress("updateUserAddress");
//        uiModel.addAttribute("editProfile", user);

        return "profile";
    }
}
