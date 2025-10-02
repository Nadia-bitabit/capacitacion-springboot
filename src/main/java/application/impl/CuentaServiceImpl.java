package application.impl;

import application.CuentaService;
import domain.modelo.Cuenta;
import domain.puertos.CuentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Cuenta updateCuenta(Long id, Cuenta cuenta) {
        return this.cuentaRepository.save(cuenta);
    }

    @Override
    public void deleteCuenta(Long id) {
        this.cuentaRepository.deleteById(id);
    }


    @Override
    public List<Cuenta> findAllCuentas() {
        return (List<Cuenta>) cuentaRepository.findAll();
    }
}
