package com.example.partnerservice.repository;

import com.example.partnerservice.domain.PartnerEntity;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PartnerRepositoryTest {

    @Autowired
    private PartnerRepository partnerRepository;
    private Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Test
    void 더미데이터_저장_테스트(){
        partnerRepository.save(new PartnerEntity());
        partnerRepository.findAll().stream().forEach(System.out::println);
    }
}