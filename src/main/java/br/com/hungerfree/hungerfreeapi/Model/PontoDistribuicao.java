package br.com.hungerfree.hungerfreeapi.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "PONTO_DISTRIBUICAO")
public class PontoDistribuicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    // Outros atributos do ponto de distribuição

    @OneToMany(mappedBy = "pontoDistribuicao", cascade = CascadeType.ALL)
    private List<Doacao> doacoes;

    // Construtores, getters e setters

    public List<Doacao> getDoacoes() {
        return doacoes;
    }

    public void setDoacoes(List<Doacao> doacoes) {
        this.doacoes = doacoes;
    }
}
