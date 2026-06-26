package com.matheus.listatarefas.controller;

import com.matheus.listatarefas.dto.TarefaRequestDTO;
import com.matheus.listatarefas.dto.TarefaResponseDTO;
import com.matheus.listatarefas.service.TarefaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @GetMapping
    public List<TarefaResponseDTO> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public TarefaResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public TarefaResponseDTO salvar(@RequestBody TarefaRequestDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public TarefaResponseDTO atualizar(@PathVariable Long id,
                                       @RequestBody TarefaRequestDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}