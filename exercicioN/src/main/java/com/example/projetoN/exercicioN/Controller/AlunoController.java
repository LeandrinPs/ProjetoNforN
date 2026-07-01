package com.example.projetoN.exercicioN.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.projetoN.exercicioN.Entity.Aluno;
import com.example.projetoN.exercicioN.Service.AlunoService;

@Controller
@RequestMapping("/alunoCTR")
public class AlunoController {

    @Autowired
    private AlunoService oAlunoService;

    @GetMapping("/main")
    public String telaMain() {
        return "main";
    }

    @GetMapping("/listarAlunos")
    public String telaListarAluno(Model oModel) {

        oModel.addAttribute("alunos",
                oAlunoService.buscaTodos());

        return "listarAluno";
    }

    @GetMapping("/formCadastrar")
    public String telaCadastrarAluno(Model oModel) {

        oModel.addAttribute("aluno", new Aluno());

        return "cadastrarAluno";
    }

    @PostMapping("/salvarAluno")
    public String cadastrarAluno(@ModelAttribute Aluno oAluno) {

        oAlunoService.cadastrarAluno(oAluno);

        return "redirect:/alunoCTR/listarAlunos";
    }

    @GetMapping("/formAlterar/{id}")
    public String telaAlterarAluno(@PathVariable Long id, Model oModel) {

        Aluno oAluno = oAlunoService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));

        oModel.addAttribute("alunoEditar", oAluno);

        return "editarAluno";
    }

    @PostMapping("/alteraAluno/{id}")
    public String alteraAluno(@PathVariable Long id, @ModelAttribute Aluno oAluno) {

        oAlunoService.alteraAluno(oAluno, id);

        return "redirect:/alunoCTR/listarAlunos";
    }

    @GetMapping("/deletarAluno/{id}")
    public String deletarAluno(@PathVariable Long id) {

        oAlunoService.deletarAluno(id);

        return "redirect:/alunoCTR/listarAlunos";
    }
}