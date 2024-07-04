package com.github.wycm.graph.framework.service;

import com.github.wycm.graph.framework.domain.CouponDTO;
import com.github.wycm.graph.framework.domain.ShopDTO;


/**
 * 优惠券服务(这里仅仅考虑店铺优惠券)，涉及rpc
 */
public class CouponService {

    /*
     * 根据地址限制和店铺信息查询店铺优惠券
     */
    public CouponDTO queryUserById(Long userId, String address, ShopDTO shopDTO) {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // 地址校验、店铺优惠券、其他优惠券叠加省略
        return new CouponDTO(shopDTO.getDiscountCount());
    }
}
