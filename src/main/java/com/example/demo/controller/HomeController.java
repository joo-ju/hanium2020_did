package com.example.demo.controller;

        import lombok.extern.slf4j.Slf4j;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class HomeController {


    @RequestMapping("/profile")
    public String viewProfilePage() {

        return "ey_profile_v3";
    }
    @RequestMapping("/index")
    public String viewIndexPage() {

        return "joh_index";
    }

    @RequestMapping("/donate_mylist")
    public String viewDonateMylistPage() {

        return "jy_donate_mylist_v3";
    }
    @RequestMapping("/profile_edit")
    public String viewProfileEditPage() {

        return "joh_profile_edit_v2";
    }
    @RequestMapping("/request_mylist")
    public String viewRequestMylistPage() {

        return "jy_request_mylist_v5";
    }
    @RequestMapping("/enroll_com")
    public String viewenroll_comPage() {

        return "enroll_com";
    }
    @RequestMapping("/enroll_res")
    public String viewenroll_resPage() {

        return "enroll_res";
    }
}
