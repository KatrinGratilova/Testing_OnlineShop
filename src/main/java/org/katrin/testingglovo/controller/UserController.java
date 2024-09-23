package org.katrin.testingglovo.controller;

import lombok.AllArgsConstructor;
import org.katrin.testingglovo.dto.OrderDto;
import org.katrin.testingglovo.service.OrderService;
import org.katrin.testingglovo.dto.UserDto;
import org.katrin.testingglovo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final OrderService orderService;

    @GetMapping
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable int id) {
        return userService.getById(id);
    }

    @PostMapping
    public UserDto save(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    @PutMapping
    public UserDto update(@RequestBody UserDto userDto) {
        return userService.updateWithoutOrders(userDto);
    }

    @GetMapping("/{id}/orders")
    public List<OrderDto> getOrders(@PathVariable int id) {
        return orderService.getByClientId(id);
    }

    @PostMapping("/{id}/orders")
    public UserDto addOrder(@PathVariable int id, @RequestBody OrderDto orderDto) {
        return userService.addOrder(id, orderDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }
}
