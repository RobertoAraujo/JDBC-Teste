package br.gov.ac.sefaz.classes;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
/**
 * Roberto Araujo de Moraes
 * Rio Branco - Acre
 *
 */
public class Autor implements Serializable {

    public static final Long SerialVersionUID= 1L;

    private Integer id;
    private String nome;
    private Integer idade;
    private LocalDate nascimento;
    private String comentario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Autor() {
    }

    public Autor(Integer id, String nome, Integer idade, LocalDate nascimento, String comentario) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.nascimento = nascimento;
        this.comentario = comentario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Autor)) return false;
        Autor autor = (Autor) o;
        return getId().equals(autor.getId()) && getNome().equals(autor.getNome()) && getIdade().equals(autor.getIdade())
                && getNascimento().equals(autor.getNascimento()) && getComentario().equals(autor.getComentario());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getIdade(), getNascimento(), getComentario());
    }

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", nome='" + nome + '\'' +
                ", idade=" + idade + ", nascimento=" + nascimento + ", comentario='" + comentario + '\'' + '}';
    }
}
