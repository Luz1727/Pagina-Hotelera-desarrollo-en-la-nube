package com.EquipoDesa.Conexion_Oracle_Clound.repository;
import com.EquipoDesa.Conexion_Oracle_Clound.model.Reservacion;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ReservacionRepository extends JpaRepository<Reservacion, Long> {
}
