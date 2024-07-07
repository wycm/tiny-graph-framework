package com.github.wycm.graph.framework.service;

import com.github.wycm.graph.framework.domain.ItemDTO;

import java.util.Collections;

/**
 * 商品中心服务，涉及rpc
 */
public class ItemCenterService {

    /*
     * 根据商品id 查询商品信息
     */
    public ItemDTO queryItemById(Long itemId) {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new ItemDTO(itemId, 22L, "复古印花短袖T恤男ins潮牌潮流半袖体恤夏季上衣服宽松重磅打底衫", Collections.singletonList("https://www.xxx.com/xxx.png"));
    }
}
