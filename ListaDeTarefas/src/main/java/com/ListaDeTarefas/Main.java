package com.ListaDeTarefas;

import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        TarefaDAO dao = new TarefaDAO();

        //Cria uma tarefa
        Tarefa t1 = new Tarefa("Dormir", false);
        dao.create(t1);

        //Lista as tarefas
        List<Tarefa> tarefas = dao.read();

        for (Tarefa t : tarefas) {
            System.out.println(t);
        }

        //Muda o título da tarefa
        dao.updateTitle(3, "Estudar Spring Boot");

        //Muda o status da tarefa
        dao.updateStatus(3, false);

        //Apaga a tarefa
        dao.delete(4);

    }
}
