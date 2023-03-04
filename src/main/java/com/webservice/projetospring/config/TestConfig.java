package com.webservice.projetospring.config;

import com.webservice.projetospring.entities.User;
import com.webservice.projetospring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
//       User user1 = new User(null, "Joao Barbosa", "joao@gmail.com", "8199898789", "12345678");
//        User user2 = new User(null, "Cris Silva", "cris@gmail.com", "81999999999", "987654321");
//
//        userRepository.saveAll(Arrays.asList(user1, user2));
    }
}
