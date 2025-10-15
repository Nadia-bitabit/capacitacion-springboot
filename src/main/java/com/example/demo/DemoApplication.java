package com.example.demo;

import com.example.demo.domain.modelo.Cuenta;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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
