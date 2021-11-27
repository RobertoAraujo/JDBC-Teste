package br.gov.ac.sefaz.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcFActory {
    private static final String USUARIO_DB = "postgres";
    private static final String SENHA_DB = "postgres";
    private static final String URL_DB = "jdbc:postgresql://localhost:25432/sabado";
    private static final String DRIVER_CLASS = "org.postgresql.Driver";

    public Connection criarConexao(){
        try {
            System.out.println("Iniciando uma conexão com o banco....");
            Class.forName(DRIVER_CLASS);
            Connection connection = DriverManager.getConnection(URL_DB, USUARIO_DB, SENHA_DB);
            System.out.println("Conectado com sucesso!!");
            return connection;

        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado.....");

        } catch (SQLException e ) {
            tratarDoBanco(e);
        }
        return null;
    }

    /**
     * Roberto Araujo 
     * Tratando erros do sql
     * @param @{link SQLException} excesão
     *
     */

    private void tratarDoBanco(SQLException e) {
        if(e.getSQLState().equals("3D000")){
            System.out.println("Banco de dados não existe");

        }else if(e.getSQLState().equals("28P01")){
            System.out.println("Senha Invalida");

        }else {
            System.out.println("SQL ERRO" + e.getMessage() + "| ERRO CODE" + e.getSQLState());
        }
    }
}
