package com.EquipoDesa.Conexion_Oracle_Clound.repository;
import com.EquipoDesa.Conexion_Oracle_Clound.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
