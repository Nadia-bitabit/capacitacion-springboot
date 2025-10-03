package domain.puertos;

import domain.modelo.Cuenta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends CrudRepository<Cuenta, Long > {

    List<Cuenta> findAll();
    boolean existsByNombreTitular(String nombreTitular);
}
