package application.impl;

import application.CuentaService;
import domain.modelo.Cuenta;
import domain.puertos.CuentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
    public Optional<Cuenta> findCuentaById(String id) {
        return this.cuentaRepository.findById(Long.valueOf(id));
    }

    @Override
    public List<Cuenta> findAllCuentas() {
        return (List<Cuenta>) cuentaRepository.findAll();
    }
}
