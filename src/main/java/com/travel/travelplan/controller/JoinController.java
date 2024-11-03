package com.travel.travelplan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.travel.travelplan.dto.JoinDTO;
import com.travel.travelplan.service.JoinService;

@Controller
public class JoinController {
    //생성자 주입으로 바꿔야해,, ㅠ^ㅠ
    @Autowired
    private JoinService joinService;


    @GetMapping("/join")
    public String joinP() {

        return "join";
    }


    @PostMapping("/joinProc")
    public String joinProcess(@ModelAttribute JoinDTO joinDTO) {

        System.out.println(joinDTO.getUsername());

        joinService.joinProcess(joinDTO);

        System.out.println("민둔민둔");

        return "redirect:/login"; // 완료 후 
    }
}