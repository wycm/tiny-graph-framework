package com.github.wycm.graph.framework.service;

import com.github.wycm.graph.framework.domain.AfterSalesDTO;

/**
 * 售后中心服务，涉及rpc
 */
public class AfterSalesService {

    /*
     * 根据itemId 查询售后信息
     */
    public AfterSalesDTO queryAfterSalesByItemId(Long itemId) {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new AfterSalesDTO(itemId, 7);
    }
}
