package com.example.demo.domain.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@jakarta.persistence.Table(name = "Transaccion")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;
    @Getter
    @Setter
    private String nombreOrigen;
    @Getter @Setter
    private String nombreDestino;
    @Getter @Setter
    private double monto;

    /**
     * Constructor por defecto de Transaccion.
     */
    public Transaccion() {}

    public Transaccion(String nombreOrigen, String nombreDestino, double monto) {
        this.nombreOrigen = nombreOrigen;
        this.nombreDestino = nombreDestino;
        this.monto = monto;
    }

}

