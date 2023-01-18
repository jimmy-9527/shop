package com.atguigu.gulimall.cart.vo;

import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CartVo {
    List<CartItemVo> items;
    private Integer countNum;
    private Integer countType;
    private BigDecimal totalAmount;
    private BigDecimal reduce = new BigDecimal("0.00");

    public Integer getCountNum() {
        int count = 0;
        if (items != null && items.size() > 0) {
            for (CartItemVo item : items) {
                count += item.getCount();
            }
        }
        return count;
    }

    public Integer getCountType() {
        int count = 0;
        if (items != null && items.size() > 0) {
            for (CartItemVo item : items) {
                count += 1;
            }
        }
        return count;
    }

    public BigDecimal getTotalAmount() {
        BigDecimal amount = new BigDecimal("0");
        if (!CollectionUtils.isEmpty(items)) {
            for (CartItemVo cartItem : items) {
                if (cartItem.getCheck()) {
                    amount = amount.add(cartItem.getTotalPrice());
                }
            }
        }
        return amount.subtract(getReduce());
    }
}
