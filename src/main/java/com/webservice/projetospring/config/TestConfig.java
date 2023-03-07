package com.webservice.projetospring.config;

import com.webservice.projetospring.domain.entities.Order;
import com.webservice.projetospring.domain.entities.User;
import com.webservice.projetospring.domain.enums.OrderStatus;
import com.webservice.projetospring.repositories.OrderRepository;
import com.webservice.projetospring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Joao Barbosa", "joao@gmail.com", "8199898789", "12345678");
        User user2 = new User(null, "Cris Silva", "cris@gmail.com", "81999999999", "987654321");

        Order order1 = new Order(null, Instant.parse("2023-03-20T19:53:07Z"), user1, OrderStatus.WAITING_PAYMENT);
        Order order2 = new Order(null, Instant.parse("2023-03-21T03:42:10Z"), user2, OrderStatus.DELIVERED);
        Order order3 = new Order(null, Instant.parse("2023-03-22T15:21:22Z"), user1, OrderStatus.PAID);

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
    }
}
