package com.webservice.projetospring.controllers;

import com.webservice.projetospring.domain.entities.Order;
import com.webservice.projetospring.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //recurso web implementado por um controlador rest
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> listUser = orderService.findAll();

        return ResponseEntity.ok().body(listUser);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order order = orderService.findById(id);

        return ResponseEntity.ok().body(order);
    }


}
