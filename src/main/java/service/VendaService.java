package service;


import model.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.VendaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private static VendaRepository vendaRepository;

    @org.jetbrains.annotations.NotNull
    public static Venda adicionarVenda(Venda venda) {
       return vendaRepository.save(venda);
    }

    public List<Venda> listarVenda() {
        return vendaRepository.findAll();
    }

 
    public Venda buscarVendaPorId(Long id) {
        Optional<Venda> vendaOptional = vendaRepository.findById(id);
        return vendaOptional.orElse(null);
    }

    public Venda atualizarVenda(Long id, Venda venda) {
        if (vendaRepository.existsById(id)){
            venda.setiD(id);
            return vendaRepository.save(venda);
        }
        else{
            return null;
        }
    }

    public void deletarVenda(Long id) {
        vendaRepository.deleteById(id);
    }
}