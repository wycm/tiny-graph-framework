package com.github.wycm.graph.framework.nodes;

import com.github.wycm.graph.framework.core.Dependency;
import com.github.wycm.graph.framework.core.GraphNode;
import com.github.wycm.graph.framework.core.RuntimeContext;
import com.github.wycm.graph.framework.domain.ItemDTO;
import com.github.wycm.graph.framework.domain.ShopDTO;
import com.github.wycm.graph.framework.service.ShopCenterService;

/**
 * 商品中心查询节点
 */
public class ShopCenterQueryNode implements GraphNode<ShopDTO> {

    @Dependency
    private ItemCenterQueryNode itemCenterQueryNode;

    @Override
    public ShopDTO process(RuntimeContext runtimeContext) {
        ItemDTO itemDTO = runtimeContext.getNodeData(itemCenterQueryNode);
        return new ShopCenterService().queryShopByShopId(itemDTO.getShopId());
    }
}
