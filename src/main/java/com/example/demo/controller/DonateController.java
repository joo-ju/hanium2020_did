package com.example.demo.controller;

import com.example.demo.model.Donate;
import com.example.demo.repository.DonateRepository;
import com.example.demo.service.DonateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
public class DonateController {
    private DonateService donateService;
    private DonateRepository donateRepository;

    @RequestMapping("/donate_mylist")
    public String ListDonate(Model uiModel) {
        List<Donate> donate = donateService.findAll();
        uiModel.addAttribute("donateA", donate);
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
