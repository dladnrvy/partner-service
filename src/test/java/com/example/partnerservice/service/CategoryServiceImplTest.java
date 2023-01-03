package com.example.partnerservice.service;

import com.example.partnerservice.domain.PartnerEntity;
import com.example.partnerservice.repository.PartnerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;


@SpringBootTest
@Transactional
class CategoryServiceImplTest {

    @Autowired private PartnerRepository partnerRepository;

    @Test
    void 카테고리아이디_조회_성공() {
        // given
        Long partnerId = 1L;
        // when
        Optional<PartnerEntity> findCategory = partnerRepository.findById(partnerId);
        // then
        Assertions.assertThat(findCategory.get()).isEqualTo(partnerId);
    }

    @Test
    void 카테고리아이디_조회_실패() {
        // given
        Long partnerId = 0L;

        // when
        Optional<PartnerEntity> findCategory = partnerRepository.findById(partnerId);
        // then
        Assertions.assertThatThrownBy(()-> findCategory.get()).isInstanceOf(NoSuchElementException.class);
    }
}