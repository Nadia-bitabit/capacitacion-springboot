package infrastructure.dto;

import domain.modelo.Cuenta;


public class CuentaDTO {
    private Long id;
    private float saldo;
    private String nombreTitular;

    public CuentaDTO(Long id, float saldo, String nombreTitular) {
        this.id = id;
        this.saldo = saldo;
        this.nombreTitular = nombreTitular;
    }

    public static CuentaDTO desdeModel(Cuenta cuenta) {
        return new CuentaDTO(
                cuenta.getId(),
                cuenta.getSaldo(),
                cuenta.getNombreTitular()
        );
    }

    public Cuenta aModel() {
        Cuenta cuenta = new Cuenta();
        cuenta.setId(this.id);
        cuenta.setSaldo(this.saldo);
        cuenta.setNombreTitular(this.nombreTitular);
        return cuenta;
    }
}
