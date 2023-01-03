package com.example.partnerservice.service;


import com.example.partnerservice.repository.CategoryRepository;
import com.example.partnerservice.repository.PartnerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private PartnerRepository partnerRepository;

    @Nested
    @DisplayName("성공케이스")
    class SuccessCase {
        @Test
        void 카테고리아이디_조회() {
            // given
            Long fakeCategoryId = 1l;
            Long fakePartnerId = 2l;

            // mocking
            given(categoryRepository.findByCategoryId(any())).willReturn(fakeCategoryId);

            // when
            Optional<Long> categoryId = categoryService.findCategoryId(fakePartnerId);

            // then
            assertThat(categoryId).isNotEmpty();
            assertEquals(categoryId.get(), fakeCategoryId);
        }
    }
    @Nested
    @DisplayName("실패케이스")
    class FailCase{
        @Test
        void 카테고리아이디_조회() {
            // given
            Long fakePartnerId = 2l;

            // mocking
            given(categoryRepository.findByCategoryId(any())).willReturn(null);

            // when
            Optional<Long> categoryId = categoryService.findCategoryId(fakePartnerId);

            // then
            assertThat(categoryId).isEmpty();
        }
    }

}