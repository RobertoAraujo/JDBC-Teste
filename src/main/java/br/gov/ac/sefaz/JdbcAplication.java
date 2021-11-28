package br.gov.ac.sefaz;

import br.gov.ac.sefaz.classes.Autor;
import br.gov.ac.sefaz.dao.AutorDao;
import br.gov.ac.sefaz.factory.JdbcFActory;

import java.sql.Connection;
import java.time.LocalDate;

public class JdbcAplication {

//    spring.datasource.driverClassName=org.postgresql.Driver
//    spring.datasource.url=jdbc:postgresql://localhost:5432/my_db
//    spring.datasource.username=postgres
//    spring.datasource.password=postgres
//
//    spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
//    spring.jpa.generate-ddl=true
//    spring.jpa.show-sql=true
//    spring.jpa.hibernate.ddl-auto=create

    public static void main(String[] args) {
        System.out.println("Aprendendo o JDBC");
//        JdbcFActory jdbcFActory= new JdbcFActory();
//        Connection conn = jdbcFActory.criarConexao();
//
//        Autor autor = new Autor();
//        autor.setId(2);
//        autor.setNome("roberto 01");
//        autor.setIdade(31);
//        autor.setNascimento(LocalDate.of(1990,10,23));
//        autor.setComentario("Agora vai java");

        AutorDao autorDao = new AutorDao();
        //autorDao.salvar(autor);
        autorDao.listaDeArry().forEach(System.out::println);
        System.out.println(autorDao.procuraPorid(1));

    }

}
