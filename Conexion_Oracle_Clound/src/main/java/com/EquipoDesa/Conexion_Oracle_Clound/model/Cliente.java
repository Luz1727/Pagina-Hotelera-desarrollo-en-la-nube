package com.EquipoDesa.Conexion_Oracle_Clound.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientes_seq_gen")
    @SequenceGenerator(name = "clientes_seq_gen", sequenceName = "clientes_seq", allocationSize = 1)
    private Long id;

    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
}

