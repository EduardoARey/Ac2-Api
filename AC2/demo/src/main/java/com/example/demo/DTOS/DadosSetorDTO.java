package com.example.demo.DTOS;

import java.util.List;

public class DadosSetorDTO {

    private Long id;
    private String nome;
    private List<FuncionarioDTO> funcionarios;



    public DadosSetorDTO() {
    }
    
    public DadosSetorDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public DadosSetorDTO(Long id, String nome, List<FuncionarioDTO> funcionarios) {
        this.id = id;
        this.nome = nome;
        this.funcionarios = funcionarios;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<FuncionarioDTO> getFuncionarios() {
        return funcionarios;
    }
    public void setFuncionarios(List<FuncionarioDTO> funcionarios) {
        this.funcionarios = funcionarios;
    }

    
}
