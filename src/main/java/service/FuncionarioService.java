package service;


import model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.FuncionarioRepository;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listarFuncionario() {
        return funcionarioRepository.findAll();
    }

    public Funcionario adicionarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario buscarFuncionarioPorId(Long id) {
    }

    public Funcionario atualizarFuncionario(Long id, Funcionario funcionario) {
    }

    public void deletarFuncionario(Long id) {
    }
}
