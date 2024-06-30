package com.kb.shop.controller;

import com.kb.shop.domain.Promotion;
import com.kb.shop.domain.Seller;
import com.kb.shop.domain.ShippingInfo;
import com.kb.shop.service.ShippingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/shipping")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    // 배송 정보를 생성하는 POST 호출을 생성합니다. (path : /shipping)
    @PostMapping("/")
    public ResponseEntity<ShippingInfo> setShippingInfo(@RequestBody ShippingInfo shippingInfo) {
        ShippingInfo newShippingInfo = new ShippingInfo();
        newShippingInfo = shippingService.setShippingInfo(shippingInfo);
        if (newShippingInfo != null) {
            return new ResponseEntity<>(newShippingInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 배송 Status를 변경하는 PUT 호출을 생성합니다. (path : /shipping)
    @PutMapping("/{id}")
    public ResponseEntity<ShippingInfo> updateShippingInfo(
            @PathVariable Long id,
            @RequestBody ShippingInfo shippingInfo
    ){
        ShippingInfo newShippingInfo = new ShippingInfo();
        newShippingInfo = shippingService.updateShippingInfo(id, shippingInfo);
        if (newShippingInfo != null) {
            return new ResponseEntity<>(newShippingInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 배송 정보를 확인하는 GET 호출을 생성합니다.  (path : /shipping)
    @GetMapping("/{id}")
    public ResponseEntity<ShippingInfo> getShippingInfo(@PathVariable Long id) {
        ShippingInfo shippingInfo = new ShippingInfo();
        shippingInfo = shippingService.getShippingInfo(id);

        if (shippingInfo != null) {
            return new ResponseEntity<>(shippingInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
