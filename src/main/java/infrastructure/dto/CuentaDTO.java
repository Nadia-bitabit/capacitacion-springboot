package infrastructure.dto;

import domain.modelo.Cuenta;

public class CuentaDTO {
    private Long id;
    private float saldo;

    public CuentaDTO(Long id, float saldo) {
        this.id = id;
        this.saldo = saldo;
    }

    public static CuentaDTO desdeModel(Cuenta cuenta) {
        return new CuentaDTO(
                cuenta.getId(),
                cuenta.getSaldo()
        );
    }

    public Cuenta aModel() {
        Cuenta cuenta = new Cuenta();
        cuenta.setId(this.id);
        cuenta.setSaldo(this.saldo);
        return cuenta;
    }
}
