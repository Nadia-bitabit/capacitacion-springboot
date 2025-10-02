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
    public ResponseEntity<List<Cuenta>> obtenerCuentas() {
        List<Cuenta> cuentas = cuentaService.findAllCuentas();
        return ResponseEntity.ok().body(cuentas);
    }

    @PostMapping("/crear")
    public ResponseEntity<Cuenta> crearCuenta(@RequestBody CuentaDTO cuenta) {
        try {
            Cuenta cuentaCreada = cuentaService.createCuenta(cuenta.aModel());
            return ResponseEntity.status(HttpStatus.CREATED).body(cuentaCreada);
        } catch (Error e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCuenta(@PathVariable Long id, @RequestBody CuentaDTO cuenta) {
        try {
            Cuenta cuentaAcualizada = cuentaService.updateCuenta(id, cuenta.aModel());
            logger.info("Cuenta actualizada con ID: {}", id);
            return ResponseEntity.ok(cuentaAcualizada);
        } catch (Error e) {
            logger.error("Error al actualizar cuenta con ID: {}", id, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCuenta(@PathVariable Long id) {
        try {
            cuentaService.deleteCuenta(id);
            logger.info("Cuenta eliminada con ID: {}", id);
            return ResponseEntity.ok().body("La cuenta fue eliminada exitosamente");
        } catch (Error e) {
            logger.error("Error al eliminar persona con ID: {}", id, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
