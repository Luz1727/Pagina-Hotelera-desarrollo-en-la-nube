package com.EquipoDesa.Conexion_Oracle_Clound.controller;
import com.EquipoDesa.Conexion_Oracle_Clound.model.Checkin;
import com.EquipoDesa.Conexion_Oracle_Clound.repository.CheckinRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173") 
@RestController
@RequestMapping("/api/checkin")
@RequiredArgsConstructor
public class CheckinController {

    private final CheckinRepository checkinRepository;

    @GetMapping
    public List<Checkin> getAllCheckins() {
        return checkinRepository.findAll();
    }

@PostMapping
public Checkin createCheckin(@RequestBody Checkin checkin) {
    try {
        return checkinRepository.save(checkin);
    } catch (Exception e) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al guardar el checkin", e);
    }
}


}