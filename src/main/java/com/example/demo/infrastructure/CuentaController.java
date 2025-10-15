package com.example.demo.infrastructure;

import com.example.demo.application.CuentaService;
import com.example.demo.domain.modelo.Cuenta;
import com.example.demo.domain.modelo.exception.NombreInvalido;
import com.example.demo.infrastructure.dto.CuentaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Cuentas", description = "Operaciones relacionadas con cuentas bancarias")
public class CuentaController {
    private static final Logger logger = LoggerFactory.getLogger(CuentaController.class);

    @Autowired
    private CuentaService cuentaService;

    // Endpoint para listar todas las cuentas
    @Operation(summary = "Listar cuentas", description = "Devuelve todas las cuentas registradas")
    @GetMapping("/cuentas")
    public ResponseEntity<List<Cuenta>> obtenerCuentas() {
        List<Cuenta> cuentas = cuentaService.findAllCuentas();
        return ResponseEntity.ok().body(cuentas);
    }

    @Operation(summary = "Crear una cuenta", description = "Crea una nueva cuenta en el sistema")
    @PostMapping("/crear")
    public ResponseEntity<?> crearCuenta(@RequestBody CuentaDTO cuenta) {
        try {
            Cuenta cuentaCreada = cuentaService.createCuenta(cuenta.aModel());
            return ResponseEntity.status(HttpStatus.CREATED).body(cuentaCreada);
        }catch (NombreInvalido nombreInvalido) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(nombreInvalido.getMessage());
        } catch (Error e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Endpoint para actualizar cuenta
    @Operation(summary = "Actualiza una cuenta", description = "Actualiza una cuenta en el sistema")
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCuenta(@PathVariable Long id, @RequestBody CuentaDTO cuenta) {
        try {
            Cuenta cuentaAcualizada = cuentaService.updateCuenta(id, cuenta.aModel());
            logger.info("Cuenta actualizada con ID: {}");
            return ResponseEntity.ok(cuentaAcualizada);
        } catch (Error e) {
            logger.error("Error al actualizar cuenta con ID: {}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @Operation(summary = "Elimina una cuenta", description = "Elimina una cuenta en el sistema")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCuenta(@PathVariable Long id) {
        try {
            cuentaService.deleteCuenta(id);
            logger.info("Cuenta eliminada con ID: {}", id);
            return ResponseEntity.ok().body("La cuenta fue eliminada exitosamente");
        } catch (Error e) {
            logger.error("Error al eliminar cuenta con ID: {}", id, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
