package com.github.wycm.graph.framework.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 售后信息
 */
@Data
@AllArgsConstructor
public class AfterSalesDTO {
    /**
     * 商品id
     */
    private Long itemId;

    /**
     * 无理由退货天数上限
     */
    private int noReasonReturnLimitDays;

    // ... 其他信息略

}
