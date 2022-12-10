package com.example.partnerservice.controller;



import com.example.partnerservice.domain.Category;
import com.example.partnerservice.domain.Partner;
import com.example.partnerservice.dto.PartnerRequestDto;
import com.example.partnerservice.dto.basic.BasicResponse;
import com.example.partnerservice.dto.basic.RtnCode;
import com.example.partnerservice.service.PartnerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/partner/")
public class PartnerController {

    private final PartnerServiceImpl partnerService;
    private final ModelMapper modelMapper;
    private Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());


    @GetMapping("/find")
    public BasicResponse getCategoryId(@RequestParam Long partnerId){
        BasicResponse basicResponse = new BasicResponse<>();
        Optional<Partner> partner = partnerService.findCategoryId(partnerId);
        if(!partner.isPresent()) basicResponse.setCode(RtnCode.FAIL);
        else {
            basicResponse.setCode(RtnCode.SUCCESS);
            basicResponse.setData(partner.get().getCategoryId());
        }
        return basicResponse;
    }



}
