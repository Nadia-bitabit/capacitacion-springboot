package com.example.demo.infrastructure.dto;

import com.example.demo.domain.modelo.Persona;
import com.example.demo.domain.modelo.Transaccion;

public class PersonaDTO {
    private Long id;
    private String nombre;
    private String direccion;

    public PersonaDTO (Long id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public static PersonaDTO desdeModelo(Persona persona) {
        return new PersonaDTO(
                persona.getId(),
                persona.getNombre(),
                persona.getDireccion()
        );
    }

    public Persona aModelo() {
        Persona persona = new Persona();
        persona.setId(this.id);
        persona.setNombre(this.nombre);
        persona.setDireccion(this.direccion);
        return persona;
    }
}
