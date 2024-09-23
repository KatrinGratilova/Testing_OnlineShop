package org.katrin.testingglovo.converter;

import org.katrin.testingglovo.entity.UserEntity;
import org.katrin.testingglovo.dto.UserDto;
import org.katrin.testingglovo.entity.OrderEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserConverter {
    public static UserDto toDto(UserEntity userEntity) {
        return UserDto.builder()
                .id(userEntity.getId())
                .email(userEntity.getEmail())
                .phoneNumber(userEntity.getPhoneNumber())
                .name(userEntity.getName())
                .password(userEntity.getPassword())
                .orders(userEntity.getOrders().stream().map(OrderEntity::getId).toList())
                .createdAt(userEntity.getCreatedAt())
                .build();
    }

    public static UserEntity toEntity(UserDto userDto) {
        List<Integer> orderDtos = Optional.ofNullable(userDto.getOrders()).orElse(new ArrayList<>());
        List<OrderEntity> orderEntities = orderDtos.stream().map(i -> OrderEntity.builder().id(i).build()).toList();
        return UserEntity.builder()
                .id(userDto.getId())
                .email(userDto.getEmail())
                .phoneNumber(userDto.getPhoneNumber())
                .name(userDto.getName())
                .password(userDto.getPassword())
                .orders(orderEntities)
                .createdAt(userDto.getCreatedAt())
                .build();
    }
}
