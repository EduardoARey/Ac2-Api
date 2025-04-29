package com.example.demo.DTOS;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.Models.Projeto;

public class DadosProjetoDTO {

    private Long id;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<FuncionarioDTO> funcionarios;

    

    public DadosProjetoDTO() {
    }

    public DadosProjetoDTO(Long id, String descricao, LocalDate dataInicio, LocalDate dataFim, List<FuncionarioDTO> funcionarios) {
        this.id = id;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.funcionarios = funcionarios;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public LocalDate getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }
    public LocalDate getDataFim() {
        return dataFim;
    }
    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
    public List<FuncionarioDTO> getFuncionarios() {
        return funcionarios;
    }
    public void setFuncionarios(List<FuncionarioDTO> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public DadosProjetoDTO(Projeto projeto) {
        this.id = projeto.getId();
        this.descricao = projeto.getDescricao();
        this.dataInicio = projeto.getDataInicio();
        this.dataFim = projeto.getDataFim();
        this.funcionarios = projeto.getFuncionarios()
            .stream()
            .map(f -> new FuncionarioDTO(f.getNome()))
            .collect(Collectors.toList());
    }
}
