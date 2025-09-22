package application;

import domain.modelo.Cuenta;

public interface CuentaService {
    public Cuenta createCuenta(Cuenta cuenta);
    public Cuenta updateCuenta(Cuenta cuenta);
    public void deleteCuenta(Cuenta cuenta);
    public Cuenta findCuentaById(String id);
}
