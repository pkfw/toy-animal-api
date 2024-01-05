package com.soboti.animalapi.controller;

import com.soboti.animalapi.dto.AnimalMemberDto;
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

    @GetMapping("/api/animal/all")
    public List<AnimalMemberVo> getAnimal() {
        List<AnimalMemberVo> animalMemberVoList = animalMemberService.selectAnimalMemberAll();
        return animalMemberVoList;
    }

    @GetMapping("/api/animal/search")
    public List<AnimalMemberVo> getAnimalSearch(String en) {
        AnimalMemberDto animalMemberDto = new AnimalMemberDto();
        animalMemberDto.setMember_en(en);
        List<AnimalMemberVo> animalMemberVoList = animalMemberService.selectAnimalMemberSearch(animalMemberDto);
        return animalMemberVoList;
    }
}
