package com.desaextremo.retodos.service;

import com.desaextremo.retodos.entity.Gadget;
import com.desaextremo.retodos.entity.Order;
import com.desaextremo.retodos.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order getOrder(int id) {
        Optional<Order> orderEncontrado = orderRepository.findById(id);

        if (orderEncontrado.isPresent()) {
            return orderEncontrado.get();
        } else {
            System.out.println("No se encontró el pedido con el id : " + id);
            return new Order();
        }
    }
    public Order save(Order order){
        return orderRepository.save(order);
    }

    public Order update(Order order) {
        if (order.getId() != null) {
            Optional<Order> orderEcontrado = orderRepository.findById(order.getId());
            if (orderEcontrado.isPresent()) {
                if (order.getRegisterDay() != null) {
                    orderEcontrado.get().setRegisterDay(order.getRegisterDay());
                }
                if (order.getStatus() != null) {
                    orderEcontrado.get().setStatus(order.getStatus());
                }
                if (order.getSalesMan() != null) {
                    orderEcontrado.get().setSalesMan(order.getSalesMan());
                }
                if (order.getProducts() != null) {
                    orderEcontrado.get().setProducts(order.getProducts());
                }
                if (order.getQuantities() != null) {
                    orderEcontrado.get().setQuantities(order.getQuantities());
                }
                return orderRepository.save(orderEcontrado.get());
            }
        } else {
            return order;
        }
        return order;
    }

    public boolean delete(int id){
        Order orderDelete;
        Optional<Order> optional = orderRepository.findById(id);

        if (optional.isPresent()){
            orderDelete = optional.get();
            orderRepository.delete(orderDelete);
            return true;
        }else {
            return false;
        }
    }

    public List<Order> getOrderByZone(String zone){
        return orderRepository.findAllBySalesMan_Zone(zone);
    }


}
