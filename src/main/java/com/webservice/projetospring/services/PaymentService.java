package com.webservice.projetospring.services;

import com.webservice.projetospring.domain.entities.Payment;
import com.webservice.projetospring.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> findAll(){
        return paymentRepository.findAll();
    }

    public Payment findById(Long id){
        Optional<Payment> payment = paymentRepository.findById(id);
        return payment.get();
    }
}
