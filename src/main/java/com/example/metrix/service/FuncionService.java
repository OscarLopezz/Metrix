package com.example.metrix.service;

import com.example.metrix.model.Funcion;
import com.example.metrix.repository.FuncionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class FuncionService {

    private FuncionRepository funcionRepository;

    public Funcion registrarFuncion(Funcion funcion) {
        return funcionRepository.save(funcion);
    }
}
