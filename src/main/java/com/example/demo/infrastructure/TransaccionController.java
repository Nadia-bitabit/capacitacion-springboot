package com.example.demo.infrastructure;

import com.example.demo.application.TransaccionService;
import com.example.demo.domain.modelo.Transaccion;
import com.example.demo.infrastructure.dto.TransaccionDTO;
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
@RequestMapping("/transaccion")
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
