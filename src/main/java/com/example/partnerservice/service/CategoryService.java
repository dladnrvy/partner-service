package com.example.partnerservice.service;


import java.util.Optional;

public interface CategoryService {
     Optional<Long> findCategoryId(Long partnerId);

}
