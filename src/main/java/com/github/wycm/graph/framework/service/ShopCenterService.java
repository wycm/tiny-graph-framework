package com.github.wycm.graph.framework.service;

import com.github.wycm.graph.framework.domain.ShopDTO;

import java.math.BigDecimal;


/**
 * 店铺中心服务，涉及rpc
 */
public class ShopCenterService {

    /*
     * 根据店铺id 查询店铺信息
     */
    public ShopDTO queryShopByShopId(Long shopId) {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new ShopDTO(shopId, "XX男装店", "专注高端男装售卖", BigDecimal.valueOf(0.8F));
    }
}
