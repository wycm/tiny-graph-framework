package com.github.wycm.graph.framework.service;

import com.github.wycm.graph.framework.domain.DeliveryDTO;

/**
 * 仓储中心配送服务，涉及rpc
 */
public class DeliverService {

    /**
     * 查询配送相关信息
     */
    public DeliveryDTO queryDeliverInfo(Long itemId, String userAddress) {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new DeliveryDTO(itemId, userAddress, 2);
    }
}
