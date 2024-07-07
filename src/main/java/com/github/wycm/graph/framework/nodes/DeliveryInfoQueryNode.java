package com.github.wycm.graph.framework.nodes;

import com.github.wycm.graph.framework.core.Dependency;
import com.github.wycm.graph.framework.core.GraphNode;
import com.github.wycm.graph.framework.core.RuntimeContext;
import com.github.wycm.graph.framework.domain.DeliveryDTO;
import com.github.wycm.graph.framework.domain.UserDTO;
import com.github.wycm.graph.framework.service.DeliverService;

/**
 * 配送信息查询节点
 */
public class DeliveryInfoQueryNode implements GraphNode<DeliveryDTO> {

    @Dependency(timeout = 300)
    private UserCenterQueryNode userCenterQueryNode;

    @Override
    public DeliveryDTO process(RuntimeContext runtimeContext) {
        UserDTO userDTO = runtimeContext.getNodeData(userCenterQueryNode);
        return new DeliverService().queryDeliverInfo(runtimeContext.getItemId(), userDTO.getAddress());
    }
}
