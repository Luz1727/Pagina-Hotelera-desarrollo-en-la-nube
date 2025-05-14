package com.EquipoDesa.Conexion_Oracle_Clound.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "facturas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "facturas_seq", sequenceName = "FACTURAS_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "empleado_id", nullable = false)
    private Empleado empleado;

    @Column(name = "fecha_facturacion")
    private java.sql.Timestamp fechaFacturacion;

    @Column(name = "forma_pago")
    private String formaPago;

    private BigDecimal impuestos;

    @Column(name = "total_pagar")
    private BigDecimal totalPagar;
}
