package com.example.metrix.repository;

import com.example.metrix.model.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface FuncionRepository extends JpaRepository<Funcion, Integer> {

   public Optional<Funcion> findByFechaAndHora(LocalDate fecha, int hora);

}
