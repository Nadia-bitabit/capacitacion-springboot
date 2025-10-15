package com.example.demo.infrastructure;

import com.example.demo.application.PersonaService;
import com.example.demo.domain.modelo.Persona;
import com.example.demo.infrastructure.dto.PersonaDTO;
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
@RequestMapping("/persona")

public class PersonaController {
    private static final Logger logger = LoggerFactory.getLogger(PersonaController.class);
    @Autowired
    PersonaService personaService;
    @Autowired
    private static final String API_SUCURSALES = "https://627303496b04786a09002b27.mockapi.io/mock/sucursales";

    @PostMapping
    public ResponseEntity<?> crearPersona(@RequestBody PersonaDTO personaDTO) {

        try {
            Persona personaNueva = personaService.crearPersona(personaDTO.aModelo());
            logger.info("Persona creada con ID: {}", personaNueva.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(personaNueva);
        } catch (Error e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
