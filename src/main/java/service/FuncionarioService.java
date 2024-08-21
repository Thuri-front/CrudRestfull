package service;


import model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.FuncionarioRepository;

import java.util.List;
import java.util.Optional;

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
        Optional<Funcionario> funcionarioOpt = funcionarioRepository.findById(id);
        return funcionarioOpt.orElse(null);
    }

    public Funcionario atualizarFuncionario(Long id, Funcionario funcionario) {
        if(funcionarioRepository.existsById(id)){
        funcionario.setiD(id);
        return funcionarioRepository.save(funcionario);
        }
        else{
            return null;
        }
    }

    public void deletarFuncionario(Long id) {
        funcionarioRepository.deleteById(id);

    }
}
