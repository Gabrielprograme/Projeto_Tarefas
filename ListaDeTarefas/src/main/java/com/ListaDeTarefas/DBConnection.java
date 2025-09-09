package com.ListaDeTarefas;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{
    private static final Dotenv env = Dotenv.load();
    private static final String URL = env.get("SUPABASE_URL");
    private static final String USER = env.get("SUPABASE_USER");
    private static final String PASSWORD = env.get("SUPABASE_PASSWORD");

    public static Connection conn() throws SQLException
    {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
