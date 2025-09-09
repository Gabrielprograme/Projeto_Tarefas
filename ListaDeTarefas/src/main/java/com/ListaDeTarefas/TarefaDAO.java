package com.ListaDeTarefas;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO
{
    public void create(Tarefa tarefa)
    {
        String sql = "INSERT INTO tarefas (titulo, status) VALUES (?, ?)";

        try (Connection conn = DBConnection.conn();
             PreparedStatement statement = conn.prepareStatement(sql))
        {
            statement.setString(1, tarefa.getTitulo());
            statement.setBoolean(2, tarefa.isStatus());
            statement.executeUpdate();

            System.out.println("Tarefa criada com sucesso");
        }
        catch (SQLException e)
        {
            System.out.println("Erro ao adicionar tarefa: " + e.getMessage());
        }
    }

    public List<Tarefa> read()
    {
        List<Tarefa> tarefas = new ArrayList<>();
        String sql = "SELECT id, titulo, status, criada_em FROM tarefas ORDER BY id";

        try (Connection conn = DBConnection.conn();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sql))
        {
            while (rs.next())
            {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                boolean status = rs.getBoolean("status");
                Timestamp ts = rs.getTimestamp("criada_em");
                LocalDateTime criadaEm = ts.toLocalDateTime();

                Tarefa tarefa = new Tarefa(id, titulo, status, criadaEm);
                tarefas.add(tarefa);
            }
        }
        catch (SQLException e)
        {
            System.out.println("Erro ao listar tarefas: " + e.getMessage());
        }
        return tarefas;
    }

    public void updateTitle(int id, String titulo)
    {
        String sql = "UPDATE tarefas SET titulo = ? WHERE id = ?";

        try (Connection conn = DBConnection.conn();
             PreparedStatement statement = conn.prepareStatement(sql))
        {
            statement.setString(1, titulo);
            statement.setInt(2, id);
            statement.executeUpdate();

            System.out.println("Título atualizado com sucesso");
        }
        catch (SQLException e)
        {
            System.err.println("Erro ao atualizar status: " + e.getMessage());
        }
    }

    public void updateStatus(int id, boolean status)
    {
        String sql = "UPDATE tarefas SET status = ? WHERE id = ?";

        try (Connection conn = DBConnection.conn();
             PreparedStatement statement = conn.prepareStatement(sql))
        {
            statement.setBoolean(1, status);
            statement.setInt(2, id);
            statement.executeUpdate();

            System.out.println("Status atualizado com sucesso");
        }
        catch (SQLException e)
        {
            System.out.println("Erro ao atualizar status: " + e.getMessage());
        }
    }

    public void delete(int id)
    {
        String sql = "DELETE FROM tarefas WHERE id = ?";

        try (Connection conn = DBConnection.conn();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Tarefa deletada com sucesso");
        }
        catch (SQLException e)
        {
            System.err.println("Erro ao deletar tarefa: " + e.getMessage());
        }
    }
}
