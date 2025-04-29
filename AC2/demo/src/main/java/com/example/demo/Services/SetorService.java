package com.example.demo.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTOS.DadosSetorDTO;
import com.example.demo.DTOS.FuncionarioDTO;
import com.example.demo.DTOS.SetorDTO;
import com.example.demo.Models.Setor;
import com.example.demo.Repositories.SetorRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class SetorService {
    @Autowired
    private SetorRepository setorRepository;

    public void adicionarSetor(SetorDTO dto) {
        Setor setor = new Setor(dto.getNome());
        setorRepository.save(setor);
    }

    public DadosSetorDTO buscarSetorPorId(Integer idSetor) {
        Setor setor = setorRepository.findById(idSetor.longValue())
            .orElseThrow(() -> new EntityNotFoundException("Setor não encontrado"));
        List<FuncionarioDTO> funcionarios = setor.getFuncionarios().stream()
            .map(f -> new FuncionarioDTO(f.getNome())).collect(Collectors.toList());
        return new DadosSetorDTO(setor.getId(), setor.getNome(), funcionarios);
    }

    public void adicionar(Setor setor) {

        System.out.println("Setor added: " + setor.getNome());
    }

    public List<DadosSetorDTO> listarSetores() {
        List<Setor> setores = setorRepository.findAll();
        return setores.stream()
                      .map(setor -> new DadosSetorDTO(setor.getId(), setor.getNome()))
                      .collect(Collectors.toList());
    }
    public void deletarSetor(Integer id) {
        if (!setorRepository.existsById(id.longValue())) {
            throw new RuntimeException("Setor não encontrado com id: " + id);
        }
        setorRepository.deleteById(id.longValue());
    }
    public void atualizarSetor(Integer id, Setor setorAtualizado) {
        
    }
    }
    
