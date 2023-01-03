package com.example.partnerservice.service;

import com.example.partnerservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /**
     * PartnerId 조회
     * @return Partner
     */
    @Override
    public Optional<Long> findCategoryId(Long partnerId) {
        Optional<Long> categoryId = Optional.ofNullable(categoryRepository.findByCategoryId(partnerId));
        return categoryId;
    }



}
