package com.github.wycm.graph.framework;

import com.alibaba.fastjson.JSON;
import com.github.wycm.graph.framework.core.GraphNode;
import com.github.wycm.graph.framework.core.NodeDispatchCenter;
import com.github.wycm.graph.framework.core.RuntimeContext;
import com.github.wycm.graph.framework.nodes.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 查询参数
        Long itemId = 666666L;
        Long userId = 111111L;

        // 需要查询的节点
        List<GraphNode<?>> nodes = Arrays.asList(new AfterSalesQueryNode()
                , new CouponQueryNode()
                , new DeliveryInfoQueryNode()
                , new EvaluateQueryNode()
                , new ItemCenterQueryNode()
                , new ShopCenterQueryNode()
                , new UserCenterQueryNode());
        // 创建上下文
        RuntimeContext runtimeContext = new RuntimeContext(itemId, userId, nodes);
        // 创建调度中心
        NodeDispatchCenter nodeDispatchCenter = new NodeDispatchCenter();

        long start = System.currentTimeMillis();
        Map<String, Object> executeResult = nodeDispatchCenter.execute(runtimeContext);
        long end = System.currentTimeMillis();
        System.out.println("finally result: " + JSON.toJSONString(executeResult));
        System.out.println("total cost time: " + (end - start) + "ms");
        nodeDispatchCenter.shutdown();
    }
}