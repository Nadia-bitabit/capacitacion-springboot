package com.example.demo.infrastructure.dto;

import com.example.demo.domain.modelo.Transaccion;

public class TransaccionDTO {
    private Long id;
    private String nombreOrigen;
    private String nombreDestino;
    private double monto;

    public TransaccionDTO (Long id, String nombreOrigen, String nombreDestino, double monto) {
        this.id = id;
        this.nombreOrigen = nombreOrigen;
        this.nombreDestino = nombreDestino;
        this.monto = monto;
    }

    public static TransaccionDTO desdeModelo(Transaccion transaccion) {
        return new TransaccionDTO(
                transaccion.getId(),
                transaccion.getNombreOrigen(),
                transaccion.getNombreDestino(),
                transaccion.getMonto()
        );
    }

    public Transaccion aModelo() {
        Transaccion transaccion = new Transaccion();
        transaccion.setId(this.id);
        transaccion.setNombreOrigen(this.nombreOrigen);
        transaccion.setNombreDestino (this.nombreDestino);
        transaccion.setMonto(this.monto);
        return transaccion;
    }
}
