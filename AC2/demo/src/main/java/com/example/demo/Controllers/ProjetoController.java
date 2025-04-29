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

import com.example.demo.DTOS.DadosProjetoDTO;
import com.example.demo.DTOS.ProjetoDTO;
import com.example.demo.Services.ProjetoService;


@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    public ResponseEntity<Void> adicionar(@RequestBody ProjetoDTO projeto) {
        projetoService.adicionarProjeto(projeto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosProjetoDTO> buscarProjetoPorId(@PathVariable Integer id) {
        DadosProjetoDTO dto = projetoService.buscarProjetoPorId(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/{idProjeto}/vincular-funcionario/{idFuncionario}")
    public ResponseEntity<Void> vincularFuncionario(@PathVariable Integer idProjeto, @PathVariable Integer idFuncionario) {
        projetoService.vincularFuncionario(idProjeto, idFuncionario);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<List<DadosProjetoDTO>> listarProjetos() {
    List<DadosProjetoDTO> lista = projetoService.listarProjetos();
    return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProjeto(@PathVariable Integer id) {
    projetoService.deletarProjeto(id);
    return ResponseEntity.noContent().build(); 
    }
    
    @PutMapping("/{id}")
public ResponseEntity<Void> atualizarProjeto(@PathVariable Integer id, @RequestBody ProjetoDTO dto) {
    projetoService.atualizarProjeto(id, dto);
    return ResponseEntity.noContent().build();
    }

}
