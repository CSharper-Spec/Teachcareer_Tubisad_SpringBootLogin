package com.hamitmizrak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//exclude:dahil etmemek
@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
}
)
public class TeachcareerTubisadSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeachcareerTubisadSpringBootApplication.class, args);

        // AWT: JOptionPanel set ayarı
        System.setProperty("java.awt.headless", "false");
    }
}
