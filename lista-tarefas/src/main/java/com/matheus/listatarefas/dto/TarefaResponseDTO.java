package com.matheus.listatarefas.dto;

public class TarefaResponseDTO {

    private Long id;
    private String titulo;
    private String descricao;

    public TarefaResponseDTO(Long id, String titulo, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }
}