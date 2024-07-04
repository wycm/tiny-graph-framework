package com.github.wycm.graph.framework.nodes;

import com.github.wycm.graph.framework.Dependency;
import com.github.wycm.graph.framework.GraphNode;
import com.github.wycm.graph.framework.RuntimeContext;
import com.github.wycm.graph.framework.domain.DeliveryDTO;
import com.github.wycm.graph.framework.domain.ItemDTO;
import com.github.wycm.graph.framework.domain.UserDTO;
import com.github.wycm.graph.framework.service.DeliverService;
import com.github.wycm.graph.framework.service.ItemCenterService;

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
