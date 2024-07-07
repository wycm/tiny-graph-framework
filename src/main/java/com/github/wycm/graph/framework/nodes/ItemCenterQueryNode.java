package com.github.wycm.graph.framework.nodes;

import com.github.wycm.graph.framework.core.GraphNode;
import com.github.wycm.graph.framework.core.RuntimeContext;
import com.github.wycm.graph.framework.domain.ItemDTO;
import com.github.wycm.graph.framework.service.ItemCenterService;

/**
 * 商品中心查询节点
 */
public class ItemCenterQueryNode implements GraphNode<ItemDTO> {

    @Override
    public ItemDTO process(RuntimeContext runtimeContext) {
        return new ItemCenterService().queryItemById(runtimeContext.getItemId());
    }
}
