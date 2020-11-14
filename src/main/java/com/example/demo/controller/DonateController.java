package com.example.demo.controller;

import com.example.demo.model.Donate;
import com.example.demo.model.Request;
import com.example.demo.repository.DonateRepository;
import com.example.demo.repository.RequestRepository;
import com.example.demo.service.DonateService;
import com.example.demo.service.RequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class DonateController {
    private DonateService donateService;
    private DonateRepository donateRepository;
    @Autowired
    private RequestService requestService;
    @Autowired
    private RequestRepository requestRepository;

    @RequestMapping("/donate_mylist")
    public String ListDonate(Model uiModel) {

        List reqTitleList = new ArrayList();
        List<Donate> donate = donateService.findAll();
        uiModel.addAttribute("donateA", donate);
        String reqId;
        Request request;
        for(Donate don : donate){
            request = don.getRequest();
            List<Donate> donateB = donateService.findByRequest(request);
            uiModel.addAttribute("donateB", donateB);
        }

//        String userId = "U00001";
//        Request request ;
//        String reqId;
//        // 각각의 기부한 헌혈증의 요청아이디를 가져와서 요청 글 제목을 보여줌
//        List<Request> requests = new ArrayList<>();
//        List<Request> requests2 = new ArrayList<>();
//        for(Donate don : donate){
//            int i = 0;
//            reqId = don.getDonateId().getReqId();
////            reqIdList.add(reqId);
//            requests = requestService.findOneByReqId(reqId);
//            request = requests.get(0);
//            i++;
//            reqTitleList.add(request.getReqTitle());
//
//        }
//        uiModel.addAttribute("reqTitleA", reqTitleList);


        return "donate_mylist";
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
