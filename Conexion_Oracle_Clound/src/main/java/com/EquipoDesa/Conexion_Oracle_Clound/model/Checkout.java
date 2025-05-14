package com.EquipoDesa.Conexion_Oracle_Clound.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "checkout")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Checkout {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "checkout_seq_gen")
    @SequenceGenerator(name = "checkout_seq_gen", sequenceName = "checkout_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Column(name = "fecha_checkout")
    private java.sql.Timestamp fechaCheckout;
}
