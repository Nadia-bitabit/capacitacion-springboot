package application;

import domain.modelo.Cuenta;

import java.util.List;

public interface CuentaService {
    public Cuenta createCuenta(Cuenta cuenta);
    public Cuenta updateCuenta(Long id, Cuenta cuenta);
    public void deleteCuenta(Long id);
    public List<Cuenta> findAllCuentas();
}
