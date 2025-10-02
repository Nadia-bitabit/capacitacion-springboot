package infrastructure;

import application.CuentaService;
import application.impl.CuentaServiceImpl;
import domain.modelo.Cuenta;
import infrastructure.dto.CuentaDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CuentaController {
    private static final Logger logger = LoggerFactory.getLogger(CuentaController.class);

    @Autowired
    private CuentaService cuentaService;

    // Endpoint para listar todas las cuentas
    @GetMapping("/cuentas")
    public ResponseEntity<List <Cuenta>> obtenerCuentas() {
        List<Cuenta> cuentas = cuentaService.findAllCuentas();
        return ResponseEntity.ok().body(cuentas);
    }
    @PostMapping
    public ResponseEntity<Cuenta> crearCuenta(@RequestBody CuentaDTO cuenta) {
        try {
            Cuenta cuentaCreada = cuentaService.createCuenta(cuenta.aModel());
            return ResponseEntity.status(HttpStatus.CREATED).body(cuentaCreada);
        } catch (Error e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
