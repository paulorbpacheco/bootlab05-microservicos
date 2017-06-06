package br.com.voffice.microservices.controller;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class AlunoResource extends Resource<Aluno> {

    AlunoResource(Aluno aluno, Link... links) {
        super(aluno, links);
    }

}