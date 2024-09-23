package org.katrin.testingglovo.service;

import lombok.AllArgsConstructor;
import org.katrin.testingglovo.dto.OrderDto;
import org.katrin.testingglovo.entity.UserEntity;
import org.katrin.testingglovo.repository.User.UserRepository;
import org.katrin.testingglovo.dto.UserDto;
import org.katrin.testingglovo.converter.OrderConverter;
import org.katrin.testingglovo.converter.UserConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor

@Service
public class UserService {
    private final UserRepository userRepository;

    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map(UserConverter::toDto).toList();
    }

    public UserDto getById(int id) {
        return userRepository.findById(id).map(UserConverter::toDto).orElseThrow();
    }

    public UserDto save(UserDto userDto) {
        UserEntity userEntity = userRepository.save(UserConverter.toEntity(userDto));
        return UserConverter.toDto(userEntity);
    }

    public UserDto updateWithoutOrders(UserDto userDto) {
        UserEntity userEntity = userRepository.updateWithoutOrders(UserConverter.toEntity(userDto));
        return UserConverter.toDto(userEntity);
    }

    public UserDto addOrder(int userId, OrderDto orderDto) {
        UserEntity userEntity = userRepository.addOrder(userId, OrderConverter.toEntity(orderDto));
        return UserConverter.toDto(userEntity);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
