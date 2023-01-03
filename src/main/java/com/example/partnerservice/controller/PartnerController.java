package com.example.partnerservice.controller;



import com.example.partnerservice.dto.basic.BasicResponse;
import com.example.partnerservice.dto.basic.RtnCode;
import com.example.partnerservice.service.CategoryServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/partner")
public class PartnerController {

    private final CategoryServiceImpl categoryService;
    private Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());


    /**
     * categoryId 조회
     * @param partnerId
     * @return BasicResponse
     */
    @ApiOperation(value="CATEGORY ID 조회", notes="정상적일 경우 CATEGORY ID 리턴 / 조회 된 데이터가 없으면 상태코드 404를 리턴 / 조회 중 오류가 발생하면 data에 오류메시지를 리턴")
    @GetMapping("/category/find")
    public ResponseEntity<BasicResponse> getCategoryId(@RequestParam Long partnerId){
        BasicResponse rtn = new BasicResponse<>();
        Optional<Long> categoryId = categoryService.findCategoryId(partnerId);
        if(!categoryId.isPresent()) rtn.setCode(RtnCode.FAIL);
        else {
            rtn.setCode(RtnCode.SUCCESS);
            rtn.setData(categoryId.get());
        }
        return ResponseEntity.ok(rtn);
    }



}
