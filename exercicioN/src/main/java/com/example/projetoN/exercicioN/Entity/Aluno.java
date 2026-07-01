package com.example.projetoN.exercicioN.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "aluno")
@Data
public class Aluno {
    
    @Id
    @GeneratedValue (strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column (name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "cpf", nullable = false, length = 50)
    private String cpf;

    @Column(name = "email", nullable = false, length = 50)
    private String email;


public Aluno () {
}


public Aluno(Long id, String nome, String cpf, String email) {
    this.id = id;
    this.nome = nome;
    this.cpf = cpf;
    this.email = email;
}



}