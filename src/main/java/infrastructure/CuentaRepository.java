package infrastructure;

import domain.modelo.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta,Integer> {

    List<Cuenta> findAllById(Iterable<Integer> integers);
    List<Cuenta> findAllByOrderBySaldoDesc();
}
