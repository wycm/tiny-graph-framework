package com.github.wycm.graph.framework;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 负责执行节点
 */
public class DefaultDriver {

    private final static Executor EXECUTOR = new ThreadPoolExecutor(500, 1000, 0L, TimeUnit.MILLISECONDS, new SynchronousQueue<>());

    public Map<String, Object> execute(RuntimeContext runtimeContext) {
        // TODO
        return null;
    }
}
