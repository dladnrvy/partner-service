package com.example.partnerservice.service;

import com.example.partnerservice.domain.Partner;
import com.example.partnerservice.repository.PartnerRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PartnerServiceImpl implements PartnerService{

    private final PartnerRepository partnerRepository;
    private Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /**
     * categoryId 조회
     * @return Category
     */
    @Override
    public Optional<Partner> findCategoryId(Long partnerId) {
        Optional<Partner> findCategory = partnerRepository.findById(partnerId);
        return findCategory;
    }



}
