package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTOS.DadosFuncionarioDTO;
import com.example.demo.DTOS.DadosProjetoDTO;
import com.example.demo.DTOS.FuncionarioDTO;
import com.example.demo.Models.Funcionario;
import com.example.demo.Services.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/add")
    public void adicionarFuncionario(@RequestBody Funcionario funcionario) {
        funcionarioService.adicionar(funcionario);
    }

    @GetMapping("/{id}/projetos")
    public List<DadosProjetoDTO> buscarProjetos(@PathVariable Long id) {
        return funcionarioService.buscarProjetos(id);
    }
    @PostMapping
    public ResponseEntity<Void> adicionar(@RequestBody Funcionario funcionario) {
    funcionarioService.adicionar(funcionario);
    return ResponseEntity.status(HttpStatus.CREATED).build();
}
    @GetMapping
    public ResponseEntity<List<DadosFuncionarioDTO>> listarFuncionarios() {
    List<DadosFuncionarioDTO> lista = funcionarioService.listarFuncionario();
    return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
public ResponseEntity<Void> deletarFuncionario(@PathVariable Integer id) {
    funcionarioService.deletarFuncionario(id);
    return ResponseEntity.noContent().build();
}
    
@PutMapping("/{id}")
public ResponseEntity<Void> atualizarFuncionario(@PathVariable Integer id, @RequestBody FuncionarioDTO dto) {
    funcionarioService.atualizarFuncionario(id, dto);
    return ResponseEntity.noContent().build();
}
}

