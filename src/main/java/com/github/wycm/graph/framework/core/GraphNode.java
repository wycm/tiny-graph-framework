package com.github.wycm.graph.framework.core;

/**
 * 基础调度节点
 */
public interface GraphNode<T> {

    T process(RuntimeContext runtimeContext);

}
