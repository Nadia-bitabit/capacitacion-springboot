package infrastructure.dto;

import domain.modelo.Cuenta;
import io.swagger.v3.oas.annotations.media.Schema;


public class CuentaDTO {
    @Schema(description = "ID único del titular de la cuenta", example = "1", required = true)
    private Long id;
    @Schema(description = "Saldo inicial de la cuenta (mínimo 0)", example = "100.00", required = true)
    private double saldo;
    @Schema(description = "Nombre único del titular de la cuenta", example = "Juan", required = true)
    private String nombreTitular;

    public CuentaDTO(Long id, double saldo, String nombreTitular) {
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
