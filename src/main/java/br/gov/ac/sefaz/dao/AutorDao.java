package br.gov.ac.sefaz.dao;

import br.gov.ac.sefaz.classes.Autor;
import br.gov.ac.sefaz.factory.JdbcFActory;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutorDao {
    public static final String sql = "INSERT INTO public.autor (id, nome, idade, nascimento, comentario) VALUES(?, ?, ?, ?, ?);";
    public static final String sqlista = "Select * from autor;";
    public static final String sqlistaporid = "Select * from autor where id =?;";

    public void salvar(Autor autor) {
        Connection conn = null;
        PreparedStatement ps = null;
//        rs = ps.executeQuery();
        conn = new JdbcFActory().criarConexao();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, autor.getId());
            ps.setString(2, autor.getNome());
            ps.setInt(3, autor.getIdade());
            ps.setDate(4, Date.valueOf(autor.getNascimento()));
            ps.setString(5, autor.getComentario());
            ps.execute();
            ps.close();
            conn.close();

            System.out.println("Foi Salvo no banco".concat(autor.getNome()));
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("não foi salvo no banco".concat(e.getMessage()));
        }
    }

    public Autor procuraPorid(Integer id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = new JdbcFActory().criarConexao();
            ps = conn.prepareStatement(sqlistaporid);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Autor autor =null;

            if (rs.next()) {
                autor = new Autor();
                autor.setId(rs.getInt("ID"));
                autor.setNome(rs.getString("NOME"));
                autor.setIdade(rs.getInt("IDADE"));
                autor.setNascimento(rs.getDate("NASCIMENTO").toLocalDate());
                autor.setComentario(rs.getString("COMENTARIO"));

            }
            conn.close();
            ps.close();
            rs.close();
            return autor;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar".concat(e.getMessage()));
            return null;
        }
    }

    public List<Autor> listaDeArry() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = new JdbcFActory().criarConexao();
            ps = conn.prepareStatement(sqlista);
            List<Autor> resultado = new ArrayList<>();
            rs = ps.executeQuery();
            while (rs.next()) {
                Autor autor = new Autor();
                autor.setId(rs.getInt("ID"));
                autor.setNome(rs.getString("NOME"));
                autor.setIdade(rs.getInt("IDADE"));
                autor.setNascimento(rs.getDate("NASCIMENTO").toLocalDate());
                autor.setComentario(rs.getString("COMENTARIO"));
                resultado.add(autor);
            }
            conn.close();
            ps.close();
            rs.close();
            return resultado;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar".concat(e.getMessage()));
            return Collections.emptyList();
        }

    }


}
