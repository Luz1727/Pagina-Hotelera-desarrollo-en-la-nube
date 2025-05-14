package com.EquipoDesa.Conexion_Oracle_Clound.repository;
import com.EquipoDesa.Conexion_Oracle_Clound.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
