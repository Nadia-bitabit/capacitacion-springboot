package application.impl;

import application.CuentaService;
import domain.modelo.Cuenta;
import infrastructure.CuentaRepository;

public class CuentaServiceImpl implements CuentaService {

    private final CuentaRepository cuentaRepository;

    public CuentaServiceImpl(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public Cuenta createCuenta(Cuenta cuenta) {
        return this.cuentaRepository.save(cuenta);
    }

    @Override
    public Cuenta updateCuenta(Cuenta cuenta) {
        return this.cuentaRepository.save(cuenta);
    }

    @Override
    public void deleteCuenta(Cuenta cuenta) {
        this.cuentaRepository.delete(cuenta);
    }

    @Override
    public Cuenta findCuentaById(String id) {
        return this.findCuentaById(id);
    }
}
