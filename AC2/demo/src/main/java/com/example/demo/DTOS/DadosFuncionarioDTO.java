package com.example.demo.DTOS;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.Models.Funcionario;

public class DadosFuncionarioDTO {
    
    private Long id;
    private String nome;
    private List<ProjetoDTO> projetos;


    public DadosFuncionarioDTO() {
    }

    public DadosFuncionarioDTO(Long id, String nome, List<ProjetoDTO> projetos) {
        this.id = id;
        this.nome = nome;
        this.projetos = projetos;
    }

    public DadosFuncionarioDTO(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
        this.projetos = funcionario.getProjetos()
            .stream()
            .map(p -> new ProjetoDTO(p.getNome()))
            .collect(Collectors.toList());
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
    public List<ProjetoDTO> getProjetos() {
        return projetos;
    }
    public void setProjetos(List<ProjetoDTO> projetos) {
        this.projetos = projetos;
    }

}
