package com.webservice.projetospring.repositories;

import com.webservice.projetospring.domain.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
