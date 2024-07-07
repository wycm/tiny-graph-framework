package com.github.wycm.graph.framework.core;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * 节点调度中心，执行入口
 */
public class NodeDispatchCenter {


    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(500, 1000, 0L, TimeUnit.MILLISECONDS, new SynchronousQueue<>());

    /**
     * 负责节点的调度执行，并返回最终数据
     */
    public Map<String, Object> execute(RuntimeContext runtimeContext) {
        List<Future<?>> futures = new ArrayList<>();
        runtimeContext.getNodes().forEach(currentExecuteNode -> {
            futures.add(executor.submit(() -> {
                CountDownLatch countDownLatch = runtimeContext.getCountDownLatch(currentExecuteNode.getClass().getName());
                if (countDownLatch != null) {
                    // 等待依赖节点执行结束
                    try {
                        System.out.println(getTracePrefix() + currentExecuteNode.getClass().getSimpleName() + " wait to be scheduled");
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException("Failed to wait for countDownLatch", e);
                    }
                }

                // 节点执行
                long startTime = System.currentTimeMillis();
                Object executeResult = currentExecuteNode.process(runtimeContext);
                long endTime = System.currentTimeMillis();
                System.out.println(getTracePrefix() + currentExecuteNode.getClass().getSimpleName() + " process cost " + (endTime - startTime) + "ms");
                runtimeContext.putNodeData(currentExecuteNode, executeResult);

                List<GraphNode<?>> endNodes = runtimeContext.getEndNodes(currentExecuteNode.getClass().getName());
                // 通知被依赖节点可以执行
                if (CollectionUtils.isNotEmpty(endNodes)) {
                    endNodes.forEach(endNode -> {
                        CountDownLatch endCountDownLatch = runtimeContext.getCountDownLatch(endNode.getClass().getName());
                        if (endCountDownLatch != null) {
                            System.out.println(getTracePrefix() + currentExecuteNode.getClass().getSimpleName() + " notice " + endNode.getClass().getSimpleName() + " success");
                            endCountDownLatch.countDown();
                        }
                    });
                }
            }));
        });
        // 等待所有节点执行完成
        futures.forEach(future -> {
            try {
                future.get();
            } catch (Exception e) {
                throw new RuntimeException("Failed to wait for get future result", e);
            }
        });
        // 返回所有执行结果
        return runtimeContext.getAllNodeData();
    }

    public void shutdown() {
        executor.shutdown();
    }

    private String getTracePrefix() {
        return "dispatch trace " + Thread.currentThread().getName() + " ";
    }
}
