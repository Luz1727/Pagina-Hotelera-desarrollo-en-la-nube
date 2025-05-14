package com.EquipoDesa.Conexion_Oracle_Clound.repository;
import com.EquipoDesa.Conexion_Oracle_Clound.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}
