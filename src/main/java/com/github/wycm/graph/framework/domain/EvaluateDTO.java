package com.github.wycm.graph.framework.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * 评价信息
 */
@Data
@AllArgsConstructor
public class EvaluateDTO {

    /**
     * 商品id
     */
    private Long itemId;

    /**
     * 评价条数
     */
    private Long count;

    /**
     * 评价内容列表
     */
    private List<String> contentList;
}
