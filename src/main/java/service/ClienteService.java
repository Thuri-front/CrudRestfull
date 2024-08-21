package service;


import model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarCliente() {
        return clienteRepository.findAll();
    }

    public Cliente adicionarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente buscarClientePorId(Long id) {
    }

    public Cliente atualizarCliente(Long id, Cliente cliente) {
    }

    public void deletarCliente(Long id) {
    }
}