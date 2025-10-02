package com.example.demo;

import domain.modelo.Cuenta;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "domain.puertos")
@ComponentScan({"com.example.demo", "application", "infrastructure", "domain"})
@EntityScan("domain.modelo")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
        // Crear una cuenta
        Cuenta cuenta;
        cuenta = new Cuenta();

        // getter con lombok
        System.out.println("Saldo inicial: " + cuenta.getSaldo());

        // Modificar el saldo con el setter lombok
        cuenta.setSaldo(2000);
        System.out.println("Saldo después de actualizar: " + cuenta.getSaldo());
	}

}
