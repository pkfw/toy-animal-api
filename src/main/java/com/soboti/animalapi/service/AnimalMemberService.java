package com.soboti.animalapi.service;

import com.soboti.animalapi.mapper.AnimalMemberMapper;
import com.soboti.animalapi.vo.AnimalMemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalMemberService {
    @Autowired
    private AnimalMemberMapper animalMemberMapper;

    public List<AnimalMemberVo> selectAnimalMember() {
        return animalMemberMapper.selectAnimalMember();
    }
}
