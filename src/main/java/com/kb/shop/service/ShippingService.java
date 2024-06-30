package com.kb.shop.service;

import com.kb.shop.domain.ShippingInfo;
import com.kb.shop.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    @Autowired
    private ShippingRepository shippingRepository;

    public ShippingInfo setShippingInfo(ShippingInfo shippingInfo) {
        shippingRepository.setShippingInfo(shippingInfo);
        return shippingRepository.selectShippingInfoByOrderIdAndOrderItemId(shippingInfo.getOrderId(), shippingInfo.getOrderItemId());
    }

    public ShippingInfo updateShippingInfo(Long id, ShippingInfo shippingInfo) {
        shippingRepository.updateShippingInfo(id, shippingInfo);
        return shippingRepository.selectShippingInfoById(id);
    }

    public ShippingInfo getShippingInfo(Long id) {
        return shippingRepository.selectShippingInfoById(id);
    }
}
