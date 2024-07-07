package com.github.wycm.graph.framework.nodes;

import com.github.wycm.graph.framework.core.GraphNode;
import com.github.wycm.graph.framework.core.RuntimeContext;
import com.github.wycm.graph.framework.domain.UserDTO;
import com.github.wycm.graph.framework.service.UserCenterService;

/**
 * 用户中心查询节点
 */
public class UserCenterQueryNode implements GraphNode<UserDTO> {

    @Override
    public UserDTO process(RuntimeContext runtimeContext) {
        return new UserCenterService().queryUserById(runtimeContext.getUserId());
    }
}
