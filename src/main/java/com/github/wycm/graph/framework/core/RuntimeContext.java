package com.github.wycm.graph.framework.core;

import lombok.Getter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

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
    @Getter
    private List<GraphNode<?>> nodes;
    /* 输入结束 */

    /**
     * 运行时的数据
     */
    private Map<String, Object> nodeName2DataMap = new ConcurrentHashMap<>();

    private Map<String, GraphNode<?>> nodeName2NodeMap = new HashMap<>();

    // 节点执行前count down latch依赖
    private Map<String, CountDownLatch> nodeName2InputCountDownLatchMap = new ConcurrentHashMap<>();

    // 节点执行后需要通知的节点列表map
    private Map<String, List<GraphNode<?>>> nodeName2noticeEndNodeListMap = new ConcurrentHashMap<>();


    public RuntimeContext(Long userId, Long itemId, List<GraphNode<?>> nodes) {
        this.userId = userId;
        this.itemId = itemId;
        this.nodes = nodes;
        nodeDependencyInject(nodes);
    }

    /**
     * 获取指定节点返回数据
     */
    public <T> T getNodeData(GraphNode<T> node) {
        return (T) nodeName2DataMap.get(node.getClass().getName());
    }

    /**
     * 获取所有节点返回数据
     */
    public Map<String, Object> getAllNodeData() {
        return nodeName2DataMap;
    }

    /**
     * put指定节点执行的输出结果
     */
    public <T> void putNodeData(GraphNode<T> node, Object data) {
        nodeName2DataMap.put(node.getClass().getName(), data);
    }

    /**
     * 获取执行后需要触发的节点list
     */
    public List<GraphNode<?>> getEndNodes(String nodeName) {
        return nodeName2noticeEndNodeListMap.get(nodeName);
    }

    /**
     * 获取指定节点依赖的countDownLatch
     */
    public  CountDownLatch getCountDownLatch(String nodeName) {
        return nodeName2InputCountDownLatchMap.get(nodeName);
    }

    /**
     * 依赖注入
     */
    private void nodeDependencyInject(List<GraphNode<?>> nodes) {
        nodes.forEach(node -> nodeName2NodeMap.put(node.getClass().getName(), node));

        nodes.forEach(currentNode -> {
            Field[] fields = currentNode.getClass().getDeclaredFields();
            // 字段注入
            int dependencyCount = 0;
            for (Field field : fields) {
                field.setAccessible(true);
                Annotation dependencyAnnotation = field.getAnnotation(Dependency.class);
                if (dependencyAnnotation == null) {
                    continue;
                }
                if (!GraphNode.class.isAssignableFrom(field.getType())) {
                    continue;
                }
                String className = field.getType().getName();
                try {
                    field.set(currentNode, nodeName2NodeMap.get(className));
                    dependencyCount++;
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Failed to set field");
                }

                // 执行后节点依赖关系构建
                nodeName2noticeEndNodeListMap.computeIfAbsent(className, k -> new ArrayList<>());
                nodeName2noticeEndNodeListMap.get(className).add(nodeName2NodeMap.get(currentNode.getClass().getName()));
            }
            if (dependencyCount > 0) {
                nodeName2InputCountDownLatchMap.put(currentNode.getClass().getName(), new CountDownLatch(dependencyCount));
            }
        });
    }


}
