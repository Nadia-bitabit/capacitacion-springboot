package application;

import domain.modelo.Transaccion;

public interface TransaccionService {

    Transaccion ejecutarTransaccion(Transaccion transaccion);
}
