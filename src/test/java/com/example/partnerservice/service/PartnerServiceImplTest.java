package com.example.partnerservice.service;

import com.example.partnerservice.domain.Partner;
import com.example.partnerservice.repository.PartnerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
class PartnerServiceImplTest {

    @Autowired private PartnerRepository partnerRepository;

    @Test
    void 카테고리아이디_조회_성공() {
        // given
        Long partnerId = 1L;
        // when
        Optional<Partner> findCategory = partnerRepository.findById(partnerId);
        // then
        Assertions.assertThat(findCategory.get().getId()).isEqualTo(partnerId);
    }

    @Test
    void 카테고리아이디_조회_실패() {
        // given
        Long partnerId = 0L;

        // when
        Optional<Partner> findCategory = partnerRepository.findById(partnerId);
        // then
        Assertions.assertThatThrownBy(()-> findCategory.get()).isInstanceOf(NoSuchElementException.class);
    }
}