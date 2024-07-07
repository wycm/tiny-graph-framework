package com.github.wycm.graph.framework.nodes;

import com.github.wycm.graph.framework.core.Dependency;
import com.github.wycm.graph.framework.core.GraphNode;
import com.github.wycm.graph.framework.core.RuntimeContext;
import com.github.wycm.graph.framework.domain.CouponDTO;
import com.github.wycm.graph.framework.domain.ShopDTO;
import com.github.wycm.graph.framework.domain.UserDTO;
import com.github.wycm.graph.framework.service.CouponService;

/**
 * 优惠券查询节点
 */
public class CouponQueryNode implements GraphNode<CouponDTO> {

    @Dependency
    private UserCenterQueryNode userCenterQueryNode;

    @Dependency
    private ShopCenterQueryNode shopCenterQueryNode;

    @Override
    public CouponDTO process(RuntimeContext runtimeContext) {

        UserDTO userDTO = runtimeContext.getNodeData(userCenterQueryNode);
        ShopDTO shopDTO = runtimeContext.getNodeData(shopCenterQueryNode);

        return new CouponService().queryUserById(runtimeContext.getUserId(), userDTO.getAddress(), shopDTO);
    }
}
