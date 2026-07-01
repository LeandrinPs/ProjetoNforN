package com.example.projetoN.exercicioN.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetoN.exercicioN.Entity.Aluno;
import com.example.projetoN.exercicioN.Repository.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> buscaTodos() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public Aluno cadastrarAluno(Aluno oAluno) {
        return alunoRepository.save(oAluno);
    }

    public Aluno alteraAluno(Aluno dadosAtualizar, Long id) {

        Aluno alunoBuscado = buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));
    
        alunoBuscado.setNome(dadosAtualizar.getNome());
        alunoBuscado.setCpf(dadosAtualizar.getCpf());
        alunoBuscado.setEmail(dadosAtualizar.getEmail());
    
        return alunoRepository.save(alunoBuscado);
    }

    public void deletarAluno(Long id) {
        alunoRepository.deleteById(id);
    }
}