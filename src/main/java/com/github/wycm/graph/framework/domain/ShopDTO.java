package com.github.wycm.graph.framework.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 店铺信息
 */
@Data
@AllArgsConstructor
public class ShopDTO {

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 店铺名
     */
    private String shopName;

    /**
     * 店铺描述
     */
    private String desc;

    /**
     * 店铺折扣
     */
    private BigDecimal discountCount;
}
