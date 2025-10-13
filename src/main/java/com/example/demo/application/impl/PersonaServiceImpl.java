package com.example.demo.application.impl;

import com.example.demo.application.PersonaService;
import com.example.demo.domain.modelo.Persona;
import com.example.demo.domain.modelo.Transaccion;
import com.example.demo.domain.puertos.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private final PersonaRepository personaRepository;

    //Constructor con un Productor, se utiliza kafka template
    @Autowired
    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    //Se envía el evento en un topic
    @Override
    public Persona crearPersona(Persona persona) {
        return this.personaRepository.save(persona);
    }
}

