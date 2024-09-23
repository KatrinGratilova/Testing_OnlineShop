package org.katrin.testingglovo.repository.Order;

import org.katrin.testingglovo.entity.OrderEntity;
import org.katrin.testingglovo.entity.OrderItemEntity;

public interface OrderRepositoryCustom {

    OrderEntity updateWithoutItems(OrderEntity order);

    OrderEntity addItem(int orderId, OrderItemEntity orderItemEntity);
}
