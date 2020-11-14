package com.example.demo.controller;

import com.example.demo.model.Donate;
import com.example.demo.model.Request;
import com.example.demo.model.User;
import com.example.demo.repository.RequestRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.RequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Controller
public class RequestController {
    @Autowired
    private RequestService requestService;
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/request_mylist")
    public String viewRequestMylistPage(Model uiModel,  HttpServletRequest httpServlet) {
        UserSession userSession = (UserSession) WebUtils.getSessionAttribute(httpServlet, "userSession");
        String userId =userSession.getUser().getUserId();

//        userId = "U00001";
        //user 정보에 따른 요청내역
        User user = userRepository.findByUserId(userId);

        List<Request> requests = requestRepository.findAllByUser(user);

        uiModel.addAttribute("requests", requests);

        return "request_mylist";
    }
}
