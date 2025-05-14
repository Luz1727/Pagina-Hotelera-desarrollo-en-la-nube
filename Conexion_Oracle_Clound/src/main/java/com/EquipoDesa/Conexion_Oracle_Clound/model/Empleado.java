package com.EquipoDesa.Conexion_Oracle_Clound.model;
import jakarta.persistence.*;
import lombok.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "empleados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empleados_seq")
    @SequenceGenerator(name = "empleados_seq", sequenceName = "empleados_seq", allocationSize = 1)
    private Long id;

    private String nombre;
    private String puesto;

    @CreationTimestamp
    @Column(name = "fecha_contratacion", updatable = false)
    private java.sql.Timestamp fechaContratacion;
}

