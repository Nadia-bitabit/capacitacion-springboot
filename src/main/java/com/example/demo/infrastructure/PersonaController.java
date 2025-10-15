package com.example.demo.infrastructure;

import com.example.demo.application.PersonaService;
import com.example.demo.domain.modelo.Persona;
import com.example.demo.infrastructure.dto.PersonaDTO;
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
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/persona")
@Tag(name = "Persona", description = "Creación de Persona")

public class PersonaController {
    private static final Logger logger = LoggerFactory.getLogger(PersonaController.class);
    @Autowired
    PersonaService personaService;
    @Autowired
    private WebClient webClient;
    private static final String API_SUCURSALES = "https://627303496b04786a09002b27.mockapi.io/mock/sucursales";

    @PostMapping
    public ResponseEntity<?> crearPersona(@RequestBody PersonaDTO personaDTO) {

        try {
            List<Map> sucursales = webClient.get()
                    .uri(API_SUCURSALES)
                    .retrieve()
                    .bodyToFlux(Map.class)
                    .collectList()
                    .block();

            Optional<Map> sucursalEncontrada = sucursales.stream()
                    .filter(s -> s.get("nombre") != null &&
                            s.get("nombre").toString().equalsIgnoreCase(personaDTO.aModelo().getNombre()))
                    .findFirst();

            logger.info("Sucursal: {}", sucursalEncontrada);
            if (sucursalEncontrada != null && sucursalEncontrada.isPresent()) {
                String direccion = sucursalEncontrada.get().get("direccion").toString();
                Persona persona = personaDTO.aModelo();
                persona.setDireccion(direccion);
                Persona personaNueva = personaService.crearPersona(persona);
                logger.info("Persona creada con ID: {}", personaNueva.getId());
                return ResponseEntity.status(HttpStatus.CREATED).body(personaNueva);
            } else {
                Persona personaNueva = personaService.crearPersona(personaDTO.aModelo());
                logger.info("Persona creada con ID: {}", personaNueva.getId());
                return ResponseEntity.status(HttpStatus.CREATED).body(personaNueva);
            }
        } catch (Error e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
