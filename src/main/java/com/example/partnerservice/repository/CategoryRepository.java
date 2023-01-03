package com.example.partnerservice.repository;


import com.example.partnerservice.domain.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    /** 먼저 적립 된 포인트 조회 _ Lock 설정 */
    @Query("select p.category.categoryId from PartnerEntity p where p.partnerId = :partnerId")
    Long findByCategoryId(Long partnerId);
}
