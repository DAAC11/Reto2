package com.desaextremo.retodos.controller;

import com.desaextremo.retodos.entity.Order;
import com.desaextremo.retodos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order){
        return orderService.save(order);
    }

    @GetMapping("/all")
    public List<Order> getAll(){
        return orderService.getAll();
    }
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable int id){
        return orderService.getOrder(id);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order){
        return orderService.update(order);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id){
        orderService.delete(id);
    }

    @GetMapping("/zona/{zone}")
    public List<Order> getOrderByZone(@PathVariable("zone") String zone){
        return orderService.getOrderByZone(zone);
    }
}
