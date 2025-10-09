package com.example.demo.domain.puertos;

import com.example.demo.domain.modelo.Transaccion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TansaccionRepository extends CrudRepository<Transaccion, Long > {
}
