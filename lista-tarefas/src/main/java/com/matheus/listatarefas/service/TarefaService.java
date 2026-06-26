package com.matheus.listatarefas.service;

import com.matheus.listatarefas.dto.TarefaRequestDTO;
import com.matheus.listatarefas.dto.TarefaResponseDTO;
import com.matheus.listatarefas.model.Tarefa;
import com.matheus.listatarefas.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public List<TarefaResponseDTO> listarTodas() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public TarefaResponseDTO buscarPorId(Long id) {
        Tarefa tarefa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        return toDTO(tarefa);
    }

    public TarefaResponseDTO salvar(TarefaRequestDTO dto) {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(dto.getTitulo());
        tarefa.setDescricao(dto.getDescricao());

        return toDTO(repository.save(tarefa));
    }

    public TarefaResponseDTO atualizar(Long id, TarefaRequestDTO dto) {
        Tarefa tarefa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        tarefa.setTitulo(dto.getTitulo());
        tarefa.setDescricao(dto.getDescricao());

        return toDTO(repository.save(tarefa));
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Tarefa não encontrada");
        }
        repository.deleteById(id);
    }

    private TarefaResponseDTO toDTO(Tarefa tarefa) {
        return new TarefaResponseDTO(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao()
        );
    }
}