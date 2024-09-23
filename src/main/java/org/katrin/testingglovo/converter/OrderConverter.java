package org.katrin.testingglovo.converter;

import org.katrin.testingglovo.dto.OrderDto;
import org.katrin.testingglovo.entity.OrderItemEntity;
import org.katrin.testingglovo.entity.UserEntity;
import org.katrin.testingglovo.entity.OrderEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderConverter {
    public static OrderDto toDto(OrderEntity orderEntity) {
        return OrderDto.builder()
                .id(orderEntity.getId())
                .clientId(orderEntity.getClient().getId())
                .status(orderEntity.getStatus())
                .checkoutDate(orderEntity.getCheckoutDate())
                .items(orderEntity.getItems().stream().map(OrderItemEntity::getId).toList())
                .build();
    }

    public static OrderEntity toEntity(OrderDto orderDto) {
        List<Integer> orderItemDtos = Optional.ofNullable(orderDto.getItems()).orElse(new ArrayList<>());
        List<OrderItemEntity> orderItemEntities = orderItemDtos.stream().map(i -> OrderItemEntity.builder().id(i).build()).toList();
        return OrderEntity.builder()
                .id(orderDto.getId())
                .client(UserEntity.builder().id(orderDto.getClientId()).build())
                .status(orderDto.getStatus())
                .checkoutDate(orderDto.getCheckoutDate())
                .items(orderItemEntities)
                .build();
    }
}
