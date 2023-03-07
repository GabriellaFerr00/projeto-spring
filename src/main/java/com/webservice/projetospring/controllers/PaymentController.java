package com.webservice.projetospring.controllers;

import com.webservice.projetospring.domain.entities.Payment;
import com.webservice.projetospring.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //recurso web implementado por um controlador rest
@RequestMapping(value = "/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<Payment>> findAll(){
        List<Payment> listPayment = paymentService.findAll();

        return ResponseEntity.ok().body(listPayment);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Payment> findById(@PathVariable Long id){
        Payment payment = paymentService.findById(id);

        return ResponseEntity.ok().body(payment);
    }


}
