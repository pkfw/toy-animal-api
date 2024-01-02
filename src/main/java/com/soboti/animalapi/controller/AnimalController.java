package com.soboti.animalapi.controller;

import com.soboti.animalapi.service.AnimalMemberService;
import com.soboti.animalapi.vo.AnimalMemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AnimalController {
    @Autowired
    private AnimalMemberService animalMemberService;

    @GetMapping("/api/animal")
    public List<AnimalMemberVo> getAnimal(String en) {
        List<AnimalMemberVo> animalMemberVoList = animalMemberService.selectAnimalMember();
//        model.addAttribute("list", animalMemberVoList);
        return animalMemberVoList;
    }
}
