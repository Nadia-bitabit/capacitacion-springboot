package application;

import domain.modelo.Cuenta;

import java.util.List;
import java.util.Optional;

public interface CuentaService {
    public Cuenta createCuenta(Cuenta cuenta);
    public Cuenta updateCuenta(Cuenta cuenta);
    public void deleteCuenta(Cuenta cuenta);
    public Optional<Cuenta> findCuentaById(String id);
    public List<Cuenta> findAllCuentas();
}
