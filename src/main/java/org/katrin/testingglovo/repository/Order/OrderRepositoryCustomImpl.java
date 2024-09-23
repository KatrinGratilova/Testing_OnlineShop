package org.katrin.testingglovo.repository.Order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.katrin.testingglovo.entity.OrderEntity;
import org.katrin.testingglovo.entity.OrderItemEntity;
import org.katrin.testingglovo.entity.ProductEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@AllArgsConstructor
@Repository
public class OrderRepositoryCustomImpl implements OrderRepositoryCustom {
    private final EntityManager entityManager;

    @Override
    @Transactional
    public OrderEntity updateWithoutItems(OrderEntity orderModified) {
        OrderEntity order = entityManager.find(OrderEntity.class, orderModified.getId());
        if (order == null)
            throw new EntityNotFoundException("Order not found for id: " + orderModified.getId());

        order.setClient(orderModified.getClient());
        order.setCheckoutDate(Optional.ofNullable(orderModified.getCheckoutDate()).orElse(order.getCheckoutDate()));
        order.setStatus(Optional.ofNullable(orderModified.getStatus()).orElse(order.getStatus()));

        order = entityManager.merge(order);

        return order;
    }

    @Override
    @Transactional
    public OrderEntity addItem(int orderId, OrderItemEntity orderItemEntity) throws EntityNotFoundException {
        OrderEntity orderEntity = entityManager.find(OrderEntity.class, orderId);
        if (orderEntity == null) {
            throw new EntityNotFoundException("Order not found for id: " + orderId);
        }
        ProductEntity productEntity = entityManager.find(ProductEntity.class, orderItemEntity.getProduct().getId());
        if (productEntity == null) {
            throw new EntityNotFoundException("Product not found for id: " + orderItemEntity.getProduct().getId());
        }

        orderItemEntity.setProduct(productEntity);
        orderItemEntity.setOrder(orderEntity);
        orderEntity.getItems().add(orderItemEntity);

        entityManager.merge(orderEntity);

        return entityManager.find(OrderEntity.class, orderEntity.getId());
    }
}
