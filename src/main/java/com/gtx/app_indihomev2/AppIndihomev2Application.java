package com.gtx.app_indihomev2;

import com.gtx.app_indihomev2.entity.Role;
import com.gtx.app_indihomev2.entity.User;
import com.gtx.app_indihomev2.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class AppIndihomev2Application {

    @Bean
    public CommandLineRunner setupDefaultUser(UserService service) {
        return args -> {
            service.save(new User(
                    "user",
                    "user123",
                    Arrays.asList(new Role("USER"), new Role("ACTUATOR")),
                    true
            ));
        };
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(AppIndihomev2Application.class, args);
    }

}
