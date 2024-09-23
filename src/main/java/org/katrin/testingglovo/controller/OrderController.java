package org.katrin.testingglovo.controller;

import lombok.AllArgsConstructor;
import org.katrin.testingglovo.dto.OrderDto;
import org.katrin.testingglovo.dto.OrderItemDto;
import org.katrin.testingglovo.service.OrderItemService;
import org.katrin.testingglovo.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;
    private OrderItemService orderItemService;

    @GetMapping()
    public List<OrderDto> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public OrderDto getById(@PathVariable int id) {
        return orderService.getById(id);
    }

    @PutMapping
    public OrderDto updateWithoutItems(@RequestBody OrderDto orderDto) {
        return orderService.updateWithoutItems(orderDto);
    }

    @GetMapping("/{id}/items")
    public List<OrderItemDto> getItems(@PathVariable int id) {
        return orderItemService.findByOrderId(id);
    }

    @PostMapping("/{id}/items")
    public OrderDto addItem(@PathVariable int id, @RequestBody OrderItemDto orderItemDto) {
        return orderService.addItem(id, orderItemDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        orderService.delete(id);
    }
}
