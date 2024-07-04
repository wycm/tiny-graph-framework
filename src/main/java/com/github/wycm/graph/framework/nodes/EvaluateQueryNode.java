package com.github.wycm.graph.framework.nodes;

import com.github.wycm.graph.framework.GraphNode;
import com.github.wycm.graph.framework.RuntimeContext;
import com.github.wycm.graph.framework.domain.EvaluateDTO;
import com.github.wycm.graph.framework.domain.UserDTO;
import com.github.wycm.graph.framework.service.EvaluateCenterService;
import com.github.wycm.graph.framework.service.UserCenterService;

/**
 * 评价中心查询节点
 */
public class EvaluateQueryNode implements GraphNode<EvaluateDTO> {

    @Override
    public EvaluateDTO process(RuntimeContext runtimeContext) {
        return new EvaluateCenterService().queryEvaluateInfoByItemId(runtimeContext.getItemId());
    }
}
