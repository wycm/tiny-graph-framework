package com.github.wycm.graph.framework.nodes;

import com.github.wycm.graph.framework.GraphNode;
import com.github.wycm.graph.framework.RuntimeContext;
import com.github.wycm.graph.framework.domain.AfterSalesDTO;
import com.github.wycm.graph.framework.service.AfterSalesService;

/**
 * 售后信息查询节点
 */
public class AfterSalesQueryNode implements GraphNode<AfterSalesDTO> {

    @Override
    public AfterSalesDTO process(RuntimeContext runtimeContext) {
        return new AfterSalesService().queryAfterSalesByItemId(runtimeContext.getItemId());
    }
}
