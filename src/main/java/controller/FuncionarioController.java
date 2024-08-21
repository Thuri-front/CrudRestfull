package controller;

import model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.FuncionarioService;

import java.util.List;

@RestController
@RequestMapping("/funcionarios") // URL base para o controller
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    // Criar um novo funcionario
    @PostMapping
    public ResponseEntity<Funcionario> criarFuncionario(@RequestBody Funcionario funcionario) {
        Funcionario novoFuncionario = funcionarioService.adicionarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFuncionario);
    }

    // Listar todos os funcionarios
    @GetMapping
    public List<Funcionario> listarFuncionario() {
        return funcionarioService.listarFuncionario();
    }

    // Buscar funcionario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarFuncionario(@PathVariable Long id) {
        Funcionario funcionario = funcionarioService.buscarFuncionarioPorId(id);
        return ResponseEntity.ok(funcionario);
    }

    // Atualizar um funcionario
    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        Funcionario funcionarioAtualizado = funcionarioService.atualizarFuncionario(id, funcionario);
        return ResponseEntity.ok(funcionarioAtualizado);
    }

    // Deletar um funcionario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id) {
        funcionarioService.deletarFuncionario(id);
        return ResponseEntity.noContent().build();
    }
}