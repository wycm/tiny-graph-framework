package com.github.wycm.graph.framework.service;

import com.github.wycm.graph.framework.domain.UserDTO;

/**
 * 用户中心服务，涉及rpc
 */
public class UserCenterService {

    /*
     * 根据uid 查询用户信息
     */
    public UserDTO queryUserById(Long userId) {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new UserDTO(userId, "wycm", "浙江省杭州市XX街道XX小区");
    }
}
