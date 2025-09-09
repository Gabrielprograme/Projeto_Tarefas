package com.ListaDeTarefas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tarefa
{
    private int id;
    private String titulo;
    private boolean status;
    private LocalDateTime criadaEm;
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Tarefa() {
    }

    public Tarefa(String titulo, boolean status) {
        this.titulo = titulo;
        this.status = status;
    }

    public Tarefa(int id, String titulo, boolean status, LocalDateTime criadaEm) {
        this.id = id;
        this.titulo = titulo;
        this.status = status;
        this.criadaEm = criadaEm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getCriadaEm() {
        return criadaEm;
    }

    public void setCriadaEm(LocalDateTime criadaEm) {
        this.criadaEm = criadaEm;
    }

    @Override
    public String toString() {
        String status = this.status ? "Concluída" : "Não concluída";
        return "Tarefa:\n"
                + "Id: " + id
                + "\nTitulo: " + titulo
                + "\nStatus: " + status
                + "\nCriada em: " + criadaEm.format(dtf);
    }
}
