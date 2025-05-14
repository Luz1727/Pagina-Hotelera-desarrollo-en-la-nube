package com.EquipoDesa.Conexion_Oracle_Clound.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reservaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservacion {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "habitacion_id", nullable = false)
    private Habitacion habitacion;

    @Column(name = "fecha_entrada")
    private java.sql.Timestamp fechaEntrada;

    @Column(name = "fecha_salida")
    private java.sql.Timestamp fechaSalida;

    @Column(name = "numero_personas")
    private int numeroPersonas;
}
