package com.EquipoDesa.Conexion_Oracle_Clound.controller;

import com.EquipoDesa.Conexion_Oracle_Clound.model.Checkout;
import com.EquipoDesa.Conexion_Oracle_Clound.repository.CheckoutRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173") 
@RestController
@RequestMapping("/api/checkout")
@RequiredArgsConstructor
public class CheckoutController {

    private final CheckoutRepository checkoutRepository;

    @GetMapping
    public List<Checkout> getAllCheckouts() {
        return checkoutRepository.findAll();
    }

    @PostMapping
    public Checkout createCheckout(@RequestBody Checkout checkout) {
        try {
            return checkoutRepository.save(checkout);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al guardar el checkin", e);
        }
    }

}
