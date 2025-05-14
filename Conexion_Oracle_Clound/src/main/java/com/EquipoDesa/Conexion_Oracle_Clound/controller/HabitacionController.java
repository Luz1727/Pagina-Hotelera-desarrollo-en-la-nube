package com.EquipoDesa.Conexion_Oracle_Clound.controller;

import com.EquipoDesa.Conexion_Oracle_Clound.model.Habitacion;
import com.EquipoDesa.Conexion_Oracle_Clound.repository.HabitacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/habitaciones")
@RequiredArgsConstructor
public class HabitacionController {

    private final HabitacionRepository habitacionRepository;

    @GetMapping
    public List<Habitacion> getAllHabitaciones() {
        return habitacionRepository.findAll();
    }

    @PostMapping
    public Habitacion createHabitacion(@RequestBody Habitacion habitacion) {
        return habitacionRepository.save(habitacion);
    }
}
