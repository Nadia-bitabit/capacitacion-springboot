package application.impl;

import application.CuentaService;
import domain.modelo.Cuenta;
import domain.modelo.exception.NombreInvalido;
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
        if (cuenta.getNombreTitular() == null || cuenta.getNombreTitular().trim().isEmpty()) {
            throw new NombreInvalido("El nombre de titular no puede ser vacio");
        }
        // 1. Verificar si el nombre ya existe
        if (cuentaRepository.existsByNombreTitular (cuenta.getNombreTitular())) {
            throw new NombreInvalido("El nombre de cuenta '" + cuenta.getNombreTitular() + "' ya está en uso.");
        }
        return this.cuentaRepository.save(cuenta);
    }

    @Override
    public Cuenta updateCuenta(Long id, Cuenta cuenta) {
        Cuenta cuentaActualizada = this.cuentaRepository.findById(id).get();
        cuentaActualizada.setNombreTitular(cuenta.getNombreTitular());
        return this.cuentaRepository.save(cuentaActualizada);
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
