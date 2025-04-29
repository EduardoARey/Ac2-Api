package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTOS.DadosProjetoDTO;
import com.example.demo.DTOS.FuncionarioDTO;
import com.example.demo.DTOS.ProjetoDTO;
import com.example.demo.Models.Funcionario;
import com.example.demo.Models.Projeto;
import com.example.demo.Repositories.FuncionarioRepository;
import com.example.demo.Repositories.ProjetoRepository;
import java.util.stream.Collectors;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProjetoService {
    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void adicionarProjeto(ProjetoDTO dto) {
        Projeto projeto = new Projeto(dto.getDescricao(), dto.getDataInicio(), dto.getDataFim());
        projetoRepository.save(projeto);
    }

    public DadosProjetoDTO buscarProjetoPorId(Integer id) {
        Projeto projeto = projetoRepository.findById(id.longValue())
            .orElseThrow(() -> new EntityNotFoundException("Projeto não encontrado"));
        List<FuncionarioDTO> funcionarios = projeto.getFuncionarios()
            .stream().map(f -> new FuncionarioDTO(f.getNome())).collect(Collectors.toList());
        return new DadosProjetoDTO(projeto.getId(), projeto.getDescricao(), projeto.getDataInicio(), projeto.getDataFim(), funcionarios);
    }

    public void vincularFuncionario(Integer idProjeto, Integer idFuncionario) {
        Projeto projeto = projetoRepository.findById(idProjeto.longValue())
            .orElseThrow(() -> new EntityNotFoundException("Projeto não encontrado"));
        Funcionario funcionario = funcionarioRepository.findById(idFuncionario.longValue())
            .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado"));
        projeto.getFuncionarios().add(funcionario);
        projetoRepository.save(projeto);
    }

    public List<DadosProjetoDTO> listarProjetos() {
        return projetoRepository.findAll()
            .stream()
            .map(DadosProjetoDTO::new)
            .collect(Collectors.toList());
    }
    public void deletarProjeto(Integer id) {
        if (!projetoRepository.existsById(id.longValue())) {
            throw new RuntimeException("Projeto não encontrado com id: " + id);
        }
        projetoRepository.deleteById(id.longValue());
    }
    public void atualizarProjeto(Integer id, ProjetoDTO dto) {
        Projeto projeto = projetoRepository.findById(id.longValue())
            .orElseThrow(() -> new RuntimeException("Projeto não encontrado com id: " + id));
    
        projeto.setDescricao(dto.getDescricao());
        projeto.setDataInicio(dto.getDataInicio());
        projeto.setDataFim(dto.getDataFim());
    
        projetoRepository.save(projeto);
    }
    public void atualizarFuncionario(Integer id, FuncionarioDTO dto) {
        Funcionario funcionario = funcionarioRepository.findById(id.longValue())
            .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com id: " + id));
    
        funcionario.setNome(dto.getNome());
        funcionarioRepository.save(funcionario);
    }
}
