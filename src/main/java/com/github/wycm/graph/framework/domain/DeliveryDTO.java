package com.github.wycm.graph.framework.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 投递信息
 */
@Data
@AllArgsConstructor
public class DeliveryDTO {

    /**
     * 商品id
     */
    private Long itemId;

    /**
     * 运输目的地
     */
    private String targetAddress;

    /**
     * 运输天数
     */
    private int transDays;

    // ... 其他信息略

}
