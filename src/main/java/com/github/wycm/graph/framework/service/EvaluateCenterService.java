package com.github.wycm.graph.framework.service;

import com.github.wycm.graph.framework.domain.EvaluateDTO;

import java.util.Collections;

/**
 * 评价中心服务，涉及rpc
 */
public class EvaluateCenterService {

    /*
     * 根据uid 查询用户信息
     */
    public EvaluateDTO queryEvaluateInfoByItemId(Long itemId) {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new EvaluateDTO(itemId, 229L, Collections.singletonList("非常透气，适合夏季天气"));
    }
}
