package service;


import model.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.VendaRepository;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public static Venda adicionarVenda(Venda venda) {
    }

    public List<Venda> listarVenda() {
        return vendaRepository.findAll();
    }

 
    public Venda buscarVendaPorId(Long id) {
    }

    public Venda atualizarVenda(Long id, Venda venda) {
    }

    public void deletarVenda(Long id) {
    }
}