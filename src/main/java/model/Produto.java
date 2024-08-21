package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity /* Indica que esta classe e uma entidade JPA, mapeada para tabela no database */
public class Produto {

    @Id /* define a variavel id como primary key */
    @GeneratedValue /* torna o id auto-increment*/
    private long id;
    private String nome;
    private double valor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
