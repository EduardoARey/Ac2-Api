package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTOS.DadosSetorDTO;
import com.example.demo.DTOS.SetorDTO;
import com.example.demo.Models.Setor;
import com.example.demo.Services.SetorService;

@RestController
@RequestMapping("/setores")
public class SetorController {

    @Autowired
    private SetorService setorService;

    @PostMapping
    public ResponseEntity<Void> adicionar(@RequestBody SetorDTO dto) {
        setorService.adicionarSetor(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public DadosSetorDTO buscarSetorPorId(@PathVariable Long id) {
        return setorService.buscarSetorPorId(id.intValue());
    }

    @GetMapping
    public ResponseEntity<List<DadosSetorDTO>> listarSetores() {
        List<DadosSetorDTO> lista = setorService.listarSetores();
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSetor(@PathVariable Integer id) {
        setorService.deletarSetor(id);
        return ResponseEntity.noContent().build(); 
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarSetor(@PathVariable Integer id, @RequestBody Setor setorAtualizado) {
        setorService.atualizarSetor(id, setorAtualizado);
        return ResponseEntity.noContent().build();
    }
}
