package com.EquipoDesa.Conexion_Oracle_Clound.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "checkin")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Checkin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "checkin_seq_gen")
    @SequenceGenerator(name = "checkin_seq_gen", sequenceName = "checkin_seq", allocationSize = 1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Column(name = "fecha_checkin")
    private java.sql.Timestamp fechaCheckin;
}