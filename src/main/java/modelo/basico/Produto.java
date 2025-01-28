package modelo.basico;

import jakarta.persistence.*;

@Entity
@Table (name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_produto", length = 200, nullable = false )
    private String nome;

    @Column(name = "preco_produto", nullable = false)
    private Double preco;

    public Produto() {

    }

    public Produto(Double preco, String nome) {
        super();
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
