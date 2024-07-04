package com.github.wycm.graph.framework;

import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 运行时上下文
 */
public class RuntimeContext {

    /* 以下为输入 */
    /**
     * 用户id
     */
    @Getter
    private Long userId;

    /**
     * 商品id
     */
    @Getter
    private Long itemId;

    /**
     * 待执行的节点
     */
    private List<GraphNode<?>> nodes;
    /* 输入结束 */

    /**
     * 运行时的数据
     */
    private Map<String, Object> nodeName2DataMap = new ConcurrentHashMap<>();

    public RuntimeContext(Long userId, Long itemId, List<GraphNode<?>> nodes) {
        this.userId = userId;
        this.itemId = itemId;
        this.nodes = nodes;
    }

    /**
     * 获取指定节点返回数据
     * @return
     */
    public <T> T getNodeData(GraphNode<T> node) {
        return (T) nodeName2DataMap.get(node.getClass().getName());
    }
}
