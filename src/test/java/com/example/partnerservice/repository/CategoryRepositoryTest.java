package com.example.partnerservice.repository;

import com.example.partnerservice.domain.CategoryEntity;
import com.example.partnerservice.domain.PartnerEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@Transactional
@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PartnerRepository partnerRepository;
    private Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    private PartnerEntity partnerEntity;
    private CategoryEntity categoryEntity;

    @Nested
    @DisplayName("성공케이스")
    class SuccessCase {
        @Test
        void 상점_저장() {
            // given
            categoryEntity = CategoryEntity.builder()
                    .type('A')
                    .name("식당")
                    .build();
            categoryRepository.save(categoryEntity);
            partnerEntity = PartnerEntity.builder()
                    .name("홍콩반점")
                    .category(categoryEntity)
                    .build();


            // when
            PartnerEntity partner =  partnerRepository.save(partnerEntity);

            // then
            assertThat(partner).isNotNull();
            assertThat(partner.getName()).isEqualTo(partnerEntity.getName());
            assertThat(partner.getCategory()).isEqualTo(partnerEntity.getCategory());
        }

        @Test
        void 카테고리_저장() {
            // given
            categoryEntity = CategoryEntity.builder()
                    .type('A')
                    .name("식당")
                    .build();

            // when
            CategoryEntity category = categoryRepository.save(categoryEntity);

            // then
            assertThat(category).isNotNull();
            assertThat(category.getName()).isEqualTo(categoryEntity.getName());
            assertThat(category.getType()).isEqualTo(categoryEntity.getType());
        }

        @Test
        void 카테고리_조회() {
            // given
            categoryEntity = CategoryEntity.builder()
                    .type('A')
                    .name("식당")
                    .build();
            categoryRepository.save(categoryEntity);
            partnerEntity = PartnerEntity.builder()
                    .name("홍콩반점")
                    .category(categoryEntity)
                    .build();
            partnerRepository.save(partnerEntity);

            // when
            Optional<Long> categoryId = Optional.ofNullable(categoryRepository.findByCategoryId(partnerEntity.getPartnerId()));

            // then
            assertThat(categoryId).isNotEmpty();
            assertThat(categoryId.get()).isEqualTo(categoryEntity.getCategoryId());
        }
    }

    @Nested
    @DisplayName("실패케이스")
    class FailCase {
        @Test
        void 상점_저장_Name_NULL() {
            // given
            categoryEntity = CategoryEntity.builder()
                    .type('A')
                    .name("식당")
                    .build();
            categoryRepository.save(categoryEntity);
            partnerEntity = PartnerEntity.builder()
                    //.name("홍콩반점")
                    .category(categoryEntity)
                    .build();

            // when & then
            Assertions.assertThatThrownBy(()-> partnerRepository.save(partnerEntity)).isInstanceOf(DataIntegrityViolationException.class);
        }

        @Test
        void 상점_저장_Category_NULL() {
            // given
            partnerEntity = PartnerEntity.builder()
                    .name("홍콩반점")
                    .build();

            // when & then
            Assertions.assertThatThrownBy(()-> partnerRepository.save(partnerEntity)).isInstanceOf(DataIntegrityViolationException.class);
        }

        @Test
        void 카테고리_저장_Name_NULL() {
            // given
            categoryEntity = CategoryEntity.builder()
                    .type('A')
                    //.name("식당")
                    .build();

            // when & then
            Assertions.assertThatThrownBy(()-> categoryRepository.save(categoryEntity)).isInstanceOf(DataIntegrityViolationException.class);
        }

        @Test
        void 카테고리_저장_Type_NULL() {
            // given
            categoryEntity = CategoryEntity.builder()
                    .type('A')
                    //.name("홍콩반점")
                    .build();

            // when & then
            Assertions.assertThatThrownBy(()-> categoryRepository.save(categoryEntity)).isInstanceOf(DataIntegrityViolationException.class);
        }

        @Test
        void 카테고리_저장() {
            // given
            categoryEntity = CategoryEntity.builder()
                    .type('A')
                    .name("식당")
                    .build();

            // when
            CategoryEntity category = categoryRepository.save(categoryEntity);

            // then
            assertThat(category).isNotNull();
            assertThat(category.getName()).isEqualTo(categoryEntity.getName());
            assertThat(category.getType()).isEqualTo(categoryEntity.getType());
        }

        @Test
        void 카테고리_조회() {
            // given
            categoryEntity = CategoryEntity.builder()
                    .type('A')
                    .name("식당")
                    .build();
            categoryRepository.save(categoryEntity);
            partnerEntity = PartnerEntity.builder()
                    .name("홍콩반점")
                    .category(categoryEntity)
                    .build();
            partnerRepository.save(partnerEntity);

            // when
            Optional<Long> categoryId = Optional.ofNullable(categoryRepository.findByCategoryId(123l));

            // then
            assertThat(categoryId).isEmpty();
        }
    }

}