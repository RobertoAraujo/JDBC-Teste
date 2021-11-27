package br.gov.ac.sefaz.classes;

import java.io.Serializable;
import java.time.LocalDate;

public class Autor implements Serializable {

    public static final Long SerialVersionUID= 1L;

    Integer id;
    String nome;
    Integer idade;
    LocalDate nascimento;
    String comentario;

}
