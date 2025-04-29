package com.example.demo.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTOS.DadosFuncionarioDTO;
import com.example.demo.DTOS.DadosProjetoDTO;
import com.example.demo.DTOS.FuncionarioDTO;
import com.example.demo.Models.Funcionario;
import com.example.demo.Repositories.FuncionarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<DadosProjetoDTO> buscarProjetos(Long id) {
        return List.of(); 
    }

    public void adicionar(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }

    public void adicionarFuncionario(FuncionarioDTO dto) {
        Funcionario funcionario = new Funcionario(dto.getNome());
        funcionarioRepository.save(funcionario);
    }

    public List<DadosProjetoDTO> buscarProjetosPorFuncionario(Integer idFuncionario) {
        Funcionario funcionario = funcionarioRepository.findById(idFuncionario.longValue())
            .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado"));

        return funcionario.getProjetos().stream().map(projeto ->
            new DadosProjetoDTO(projeto.getId(), projeto.getDescricao(), projeto.getDataInicio(), projeto.getDataFim(), null)
        ).collect(Collectors.toList());
    }
    public List<DadosFuncionarioDTO> listarFuncionario() {
        return funcionarioRepository.findAll()
            .stream()
            .map(DadosFuncionarioDTO::new)
            .collect(Collectors.toList());
    }
    public void deletarFuncionario(Integer id) {
        if (!funcionarioRepository.existsById(id.longValue())) {
            throw new RuntimeException("Funcionário não encontrado com id: " + id);
        }
        funcionarioRepository.deleteById(id.longValue());
    }
    public void atualizarFuncionario(Integer id, FuncionarioDTO dto) {
        Funcionario funcionario = funcionarioRepository.findById(id.longValue())
            .orElseThrow(() -> new EntityNotFoundException("Funcionario não encontrado"));
        funcionario.setNome(dto.getNome());
        funcionarioRepository.save(funcionario);
}
}
