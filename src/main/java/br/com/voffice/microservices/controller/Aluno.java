package br.com.voffice.microservices.controller;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Aluno {

    private Long id;
    private String nome;
    private Integer matricula;
    private String email;

    Aluno(Long id, String nome, Integer matricula, String email) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
    }

    Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
