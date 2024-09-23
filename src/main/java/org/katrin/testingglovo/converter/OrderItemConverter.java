package org.katrin.testingglovo.converter;

import org.katrin.testingglovo.entity.OrderItemEntity;
import org.katrin.testingglovo.entity.ProductEntity;
import org.katrin.testingglovo.dto.OrderItemDto;
import org.katrin.testingglovo.entity.OrderEntity;

public class OrderItemConverter {
    public static OrderItemDto toDto(OrderItemEntity orderItemEntity) {
        return OrderItemDto.builder()
                .id(orderItemEntity.getId())
                .price(orderItemEntity.getPrice())
                .quantity(orderItemEntity.getQuantity())
                .orderId(orderItemEntity.getOrder().getId())
                .productId(orderItemEntity.getProduct().getId())
                .build();
    }

    public static OrderItemEntity toEntity(OrderItemDto orderItemDto) {
        return OrderItemEntity.builder()
                .id(orderItemDto.getId())
                .price(orderItemDto.getPrice())
                .quantity(orderItemDto.getQuantity())
                .product(ProductEntity.builder().id(orderItemDto.getProductId()).build())
                .order(OrderEntity.builder().id(orderItemDto.getOrderId()).build())
                .build();
    }
}
