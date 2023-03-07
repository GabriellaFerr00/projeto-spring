package com.webservice.projetospring.config;

import com.webservice.projetospring.domain.entities.*;
import com.webservice.projetospring.domain.enums.OrderStatus;
import com.webservice.projetospring.repositories.*;
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
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private PaymentRepository paymentRepository;


    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Joao Barbosa", "joao@gmail.com", "8199898789", "12345678");
        User user2 = new User(null, "Cris Silva", "cris@gmail.com", "81999999999", "987654321");

        Order order1 = new Order(null, Instant.parse("2023-03-20T19:53:07Z"), user1, OrderStatus.WAITING_PAYMENT);
        Order order2 = new Order(null, Instant.parse("2023-03-21T03:42:10Z"), user2, OrderStatus.DELIVERED);
        Order order3 = new Order(null, Instant.parse("2023-03-22T15:21:22Z"), user1, OrderStatus.PAID);

        Category category1 = new Category(null, "Electronics");
        Category category2 = new Category(null, "Books");
        Category category3 = new Category(null, "Computers");

        Product product1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product product2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product product3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product product4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product product5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));

        product1.getCategories().add(category2);
        product2.getCategories().add(category1);
        product2.getCategories().add(category3);
        product3.getCategories().add(category3);
        product4.getCategories().add(category3);
        product5.getCategories().add(category2);

        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));

        OrderItem oi1 = new OrderItem(2, product1.getPrice(), order1, product1);
        OrderItem oi2 = new OrderItem(1, product3.getPrice(), order1, product3);
        OrderItem oi3 = new OrderItem( 2, product3.getPrice(), order2, product3);
        OrderItem oi4 = new OrderItem( 2, product5.getPrice(), order3, product5);

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        Payment payment1 = new Payment(null,Instant.parse("2023-03-22T17:21:22Z"), order3);
        //obs: para salvar um objeto dependente numa relacao um para um nao se chama o respository do proprio objeto
        //se faz uma associacao em mao dupla em memoria
        //associa o pedido ao pagamento
        //ai manda salvar novamente o PEDIDO e o jpa se encarrega de salvar esse pagamento do pedido
        order3.setPayment(payment1);

        orderRepository.save(order3);

    }
}
