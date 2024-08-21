package controller;

import model.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.VendaService;
import java.util.List;

@RestController
@RequestMapping("/produtos") // URL base para o controller
public class VendaController {

    @Autowired
    private VendaService vendaService;

    // Criar uma nova venda
    @PostMapping
    public ResponseEntity<Venda> criarVenda(@RequestBody Venda venda) {
        Venda novaVenda = VendaService.adicionarVenda(venda);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaVenda);
    }

    // Listar todos as vendas
    @GetMapping
    public List<Venda> listarVenda() {
        return vendaService.listarVenda();
    }

    // Buscar venda por ID
    @GetMapping("/{id}")
    public ResponseEntity<Venda> buscarVenda(@PathVariable Long id) {
        Venda venda = vendaService.buscarVendaPorId(id);
        return ResponseEntity.ok(venda);
    }

    // Atualizar uma venda
    @PutMapping("/{id}")
    public ResponseEntity<Venda> atualizarVenda(@PathVariable Long id, @RequestBody Venda venda) {
        Venda vendaAtualizada = vendaService.atualizarVenda(id, venda);
        return ResponseEntity.ok(vendaAtualizada);
    }

    // Deletar uma venda
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVenda(@PathVariable Long id) {
        vendaService.deletarVenda(id);
        return ResponseEntity.noContent().build();
    }
}