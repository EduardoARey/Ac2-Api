package com.example.demo.Repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {


    @Query("SELECT p FROM Projeto p LEFT JOIN FETCH p.funcionarios WHERE p.id = :id")
    Projeto findProjetoWithFuncionariosById(@Param("id") Long id);

    List<Projeto> findByDataInicioBetween(LocalDate dataInicio, LocalDate dataFim);
    @Query("SELECT p FROM Projeto p LEFT JOIN FETCH p.funcionarios WHERE p.id = :id")
    Optional<Projeto> findProjetoWithFuncionariosByIdCustom(@Param("id") Long id);
}
