package com.example.partnerservice.repository;


import com.example.partnerservice.domain.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {

}
