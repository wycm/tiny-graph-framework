package com.github.wycm.graph.framework.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ItemDTO {

    /**
     * 商品id
     */
    private Long itemId;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 图片列表
     */
    private List<String> picUrls;

    // ... 其他信息略
}
