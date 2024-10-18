package com.example.metrix.controller;

import com.example.metrix.model.Compra;
import com.example.metrix.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
//
//@RestController
//@RequestMapping("api/compra")
//public class CompraController {
//    @Autowired
//    private CompraRepository compraRepository;
//
//    @CrossOrigin
//    @PostMapping("registrar-compra")
//    public RequestEntity<Compra> registrarCompra(@RequestBody Compra compra) {
//        Compra compra1 = compraRepository.save(compra);
//        return ResponseEntity.status(HttpStatus.CREATED).body(compra1);
//    }
//
//}
