package com.example.partnerservice.service;


import com.example.partnerservice.domain.Partner;
import com.example.partnerservice.dto.basic.BasicResponse;

import java.util.Optional;

public interface PartnerService {
     Optional<Partner> findCategoryId(Long categoryId);

}
