package com.github.wycm.graph.framework.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户昵称
     */
    private String nick;

    /**
     * 地址
     */
    private String address;

    // ... 其他信息略

}
