package com.example.metrix.controller;

import com.example.metrix.clases.FuncionConPeliculaDTO;
import com.example.metrix.model.Funcion;
import com.example.metrix.model.Pelicula;
import com.example.metrix.repository.FuncionRepository;
import com.example.metrix.repository.PeliculaRepository;
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

    @Autowired
    private PeliculaRepository peliculaRepository;

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
    public ResponseEntity<?> registrarFuncion(@RequestBody FuncionConPeliculaDTO funcionDTO){
        Pelicula pelicula = funcionDTO.getPelicula();
        Funcion funcion = funcionDTO.getFuncion();
        Optional<Funcion> funcionExistente = funcionRepository.findByFechaAndHora(funcion.getFecha(), funcion.getHora());
        if (funcionExistente.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe una función programada en esa fecha y hora.");
        }
        Pelicula peliculaGuardada = peliculaRepository.save(pelicula);

        funcion.setPelicula(peliculaGuardada);

        Funcion funcionGuardada = funcionRepository.save(funcion);

        return ResponseEntity.status(HttpStatus.CREATED).body(funcionGuardada);
    }

    @CrossOrigin
    @PostMapping("registrar_funcion_pelicula")
    public ResponseEntity<?> registrarFuncion(@RequestBody Funcion funcion, @RequestParam Integer idPelicula) {
        Optional<Pelicula> peliculaOptional = peliculaRepository.findById(idPelicula);
        if (!peliculaOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Optional<Funcion> funcionExistente = funcionRepository.findByFechaAndHora(funcion.getFecha(), funcion.getHora());
        if (funcionExistente.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Ya existe una función programada en esa fecha y hora.");
        }

        funcion.setPelicula(peliculaOptional.get());
        Funcion f1 = funcionRepository.save(funcion);
        return ResponseEntity.status(HttpStatus.CREATED).body(f1);
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
