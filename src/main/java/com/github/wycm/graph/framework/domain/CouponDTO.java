package com.github.wycm.graph.framework.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 优惠券信息
 */
@Data
@AllArgsConstructor
public class CouponDTO {

    /**
     * 折扣数
     */
    private BigDecimal totalDiscountCount;

    // ... 其他信息略

}
