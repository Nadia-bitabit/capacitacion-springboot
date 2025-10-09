package com.example.demo.application;

import com.example.demo.domain.modelo.Transaccion;

public interface TransaccionService {

    Transaccion ejecutarTransaccion(Transaccion transaccion);
}
