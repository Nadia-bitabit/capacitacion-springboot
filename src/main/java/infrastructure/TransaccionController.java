package infrastructure;

import application.TransaccionService;
import domain.modelo.Transaccion;
import infrastructure.dto.TransaccionDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "Transaccion", description = "Operaciones relacionadas con cuentas bancarias")
public class TransaccionController {
    private static final Logger logger = LoggerFactory.getLogger(TransaccionController.class);
    @Autowired
    TransaccionService transaccionService;

    @PostMapping
    public ResponseEntity<?> ejecutarTransaccion(@RequestBody TransaccionDTO transaccionDTO) {
        try {
            Transaccion transaccionNueva = transaccionService.ejecutarTransaccion(transaccionDTO.aModelo());
            logger.info("Transaccion realizada con ID: {}", transaccionNueva.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(transaccionNueva);
        } catch (Error e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
