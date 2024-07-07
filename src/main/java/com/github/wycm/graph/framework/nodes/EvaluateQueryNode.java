package com.github.wycm.graph.framework.nodes;

import com.github.wycm.graph.framework.core.GraphNode;
import com.github.wycm.graph.framework.core.RuntimeContext;
import com.github.wycm.graph.framework.domain.EvaluateDTO;
import com.github.wycm.graph.framework.service.EvaluateCenterService;

/**
 * 评价中心查询节点
 */
public class EvaluateQueryNode implements GraphNode<EvaluateDTO> {

    @Override
    public EvaluateDTO process(RuntimeContext runtimeContext) {
        return new EvaluateCenterService().queryEvaluateInfoByItemId(runtimeContext.getItemId());
    }
}
