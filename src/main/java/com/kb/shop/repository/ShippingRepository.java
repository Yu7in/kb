package com.kb.shop.repository;

import com.kb.shop.domain.ShippingInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ShippingRepository {
    private final JdbcTemplate jdbcTemplate;

    public ShippingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setShippingInfo(ShippingInfo shippingInfo) {
        String sql = "INSERT INTO shipping_info (order_id, order_item_id, shipping_status) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, shippingInfo.getOrderId(), shippingInfo.getOrderItemId(), shippingInfo.getShippingStatus());
    }

    public ShippingInfo selectShippingInfoByOrderIdAndOrderItemId(Long orderId, Long orderItemId) {
        String sql = "SELECT * FROM shipping_info WHERE order_id = ? AND order_item_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{orderId, orderItemId}, BeanPropertyRowMapper.newInstance(ShippingInfo.class));
    }

    public void updateShippingInfo(Long id, ShippingInfo shippingInfo) {
        String sql = "UPDATE shipping_info SET shipping_status = ? WHERE id = ?";
        jdbcTemplate.update(sql, shippingInfo.getShippingStatus().toString(), id);
    }

    public ShippingInfo selectShippingInfoById(Long id) {
        String sql = "SELECT * FROM shipping_info WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, BeanPropertyRowMapper.newInstance(ShippingInfo.class));
    }
}
