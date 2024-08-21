package service;

import model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

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
        Optional<Cliente> clienteOpt = clienteRepository.findById(id);
        return clienteOpt.orElse(null); // Retorna null se o cliente não for encontrado
    }

    public Cliente atualizarCliente(Long id, Cliente cliente) {
        if (clienteRepository.existsById(id)) {
            cliente.setiD(id);
            return clienteRepository.save(cliente);
        }
        return null; // Retorna null se o cliente não existir
    }

    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}