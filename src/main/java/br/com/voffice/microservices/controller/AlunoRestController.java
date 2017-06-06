package br.com.voffice.microservices.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


import java.util.OptionalInt;
import java.util.stream.IntStream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")

public class AlunoRestController {

    private List<Aluno> list = new ArrayList<>();
    private AlunoResourceAssembler assembler = new AlunoResourceAssembler();

    @PostConstruct
    public void init() {
        list.add(new Aluno(1L, "Nome1", 11, "nome1@email.com"));
        list.add(new Aluno(2L, "Nome2", 22, "nome2@email.com"));
        list.add(new Aluno(3L, "Nome3", 33, "nome3@email.com"));
        list.add(new Aluno(4L, "Nome4", 44, "nome4@email.com"));
        list.add(new Aluno(5L, "Nome5", 55, "nome5@email.com"));
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<AlunoResource>> getAll() {
        return new ResponseEntity<>(assembler.toResources(list), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResource> get(@PathVariable Long id) {
        OptionalInt index = IntStream.range(0, list.size())
                .filter(i -> list.get(i).getId().equals(id)).findFirst();
        if (index.isPresent()) {
            Aluno aluno = list.get(index.getAsInt());
            return new ResponseEntity<>(assembler.toResource(aluno), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<AlunoResource> create(@RequestBody Aluno aluno) {
        if (list.add(aluno)) {
            return new ResponseEntity<>(assembler.toResource(aluno), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoResource> update(@PathVariable Long id, @RequestBody Aluno aluno) {
        OptionalInt index = IntStream.range(0, list.size())
                .filter(i -> list.get(i).getId().equals(id)).findFirst();
        if (index.isPresent()) {
            list.add(aluno);
            return new ResponseEntity<>(assembler.toResource(aluno), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AlunoResource> delete(@PathVariable Long id) {
        OptionalInt index = IntStream.range(0, list.size()).filter(i -> list.get(i).getId().equals(id)).findFirst();
        if (index.isPresent()) {
            Aluno aluno = list.remove(index.getAsInt());
            return new ResponseEntity<>(assembler.toResource(aluno), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

