package com.example.metrix.controller;

import com.example.metrix.model.Funcion;
import com.example.metrix.repository.FuncionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/funciones")
public class FuncionController {

    @Autowired
    private FuncionRepository funcionRepository;

    @CrossOrigin
    @GetMapping("/todas")
    public List<Funcion> retornarTodasFunciones() {
        return funcionRepository.findAll();
    }

    //ResponseEntity<Funcion> esto es un tipo de dato para retornar si no se encuentra la pelicula
    @CrossOrigin
    @GetMapping("/detalle_funcion/{id}")
    public ResponseEntity<Funcion> detallesFuncion(@PathVariable Integer id){
        Optional<Funcion> funcion = funcionRepository.findById(id);
        return funcion.isPresent() ? ResponseEntity.ok(funcion.get()) : ResponseEntity.notFound().build();
    }
    @CrossOrigin
    @PostMapping("registrar_funcion")
    public ResponseEntity<Funcion> registrarFuncion(@RequestBody Funcion funcion){
        Funcion f = funcionRepository.save(funcion);
        return ResponseEntity.status(HttpStatus.CREATED).body(f);
    }
    @CrossOrigin
    @DeleteMapping("/borrar_funcion/{id}")
    public ResponseEntity<Void> borrarFuncion(@PathVariable Integer id){
        if(!funcionRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        funcionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @PutMapping("/actulizar/{id}")
    public  ResponseEntity<Funcion> actulizarFuncion(@PathVariable Integer id, @RequestBody Funcion detallesNuevfuncion){
        if(!funcionRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        detallesNuevfuncion.setId(id);
        Funcion nuevosDatos = funcionRepository.save(detallesNuevfuncion);
        return ResponseEntity.ok(nuevosDatos);
    }

}
