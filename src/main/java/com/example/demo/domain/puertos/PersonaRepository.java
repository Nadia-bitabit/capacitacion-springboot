package com.example.demo.domain.puertos;
import com.example.demo.domain.modelo.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository<Persona, Long > {
}
