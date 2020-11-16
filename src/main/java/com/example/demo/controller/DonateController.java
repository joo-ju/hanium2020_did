package com.example.demo.controller;

import com.example.demo.model.Donate;
import com.example.demo.model.Request;
import com.example.demo.model.User;
import com.example.demo.repository.DonateRepository;
import com.example.demo.repository.RequestRepository;
import com.example.demo.service.DonateService;
import com.example.demo.service.RequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class DonateController {
    @Autowired
    private DonateService donateService;
    @Autowired
    private DonateRepository donateRepository;
    @Autowired
    private RequestService requestService;
    @Autowired
    private RequestRepository requestRepository;

    @RequestMapping("/donate_mylist")
    public String ListDonate(Model uiModel, HttpServletRequest httpServlet) {
        UserSession userSession = (UserSession) WebUtils.getSessionAttribute(httpServlet, "userSession");
        String userId =userSession.getUser().getUserId();
        User user = userSession.getUser();

        // user 정보에 따른 기부 내역
        List<Donate> donate = donateRepository.findAllByUser(user);

        // donate 테이블의 reqId 에 따른 요청글 찾아서 웹으로 전달
        Request request;
        for(Donate don : donate){
            request = don.getRequest();
            List<Donate> donateB = donateRepository.findByRequest(request);
            uiModel.addAttribute("donateA", donateB);
        }


        return "donate_mylist";
    }
    @RequestMapping("/donate_enroll")
    public String EnrollDonate(Model uiModel, HttpServletRequest httpServlet) {


        return "donate_enroll";
    }
    @Autowired
    public void setDonateService(DonateService donateService){ this.donateService = donateService;}
    @Autowired
    public void setDonateRepository(DonateRepository donateRepository){ this.donateRepository = donateRepository;}
    @Autowired
    public DonateService getDonateService() {
        return donateService;
    }
    @Autowired
    public DonateRepository getDonateRepository() {
        return donateRepository;
    }
}
