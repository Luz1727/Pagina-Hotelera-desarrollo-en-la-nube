package com.EquipoDesa.Conexion_Oracle_Clound.controller;

import com.EquipoDesa.Conexion_Oracle_Clound.model.Reservacion;
import com.EquipoDesa.Conexion_Oracle_Clound.repository.ReservacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173") 
@RestController
@RequestMapping("/api/reservaciones")
@RequiredArgsConstructor
public class ReservacionController {

    private final ReservacionRepository reservacionRepository;

    @GetMapping
    public List<Reservacion> getAllReservaciones() {
        return reservacionRepository.findAll();
    }

    @PostMapping
    public Reservacion createReservacion(@RequestBody Reservacion reservacion) {
        return reservacionRepository.save(reservacion);
    }
}
