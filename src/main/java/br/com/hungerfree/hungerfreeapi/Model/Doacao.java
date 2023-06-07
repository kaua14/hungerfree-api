package br.com.hungerfree.hungerfreeapi.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "DOACAO")
public class Doacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    // Outros atributos da doação

    @ManyToOne
    @JoinColumn(name = "ponto_distribuicao_id")
    private PontoDistribuicao pontoDistribuicao;

    // Construtores, getters e setters

    public PontoDistribuicao getPontoDistribuicao() {
        return pontoDistribuicao;
    }

    public void setPontoDistribuicao(PontoDistribuicao pontoDistribuicao) {
        this.pontoDistribuicao = pontoDistribuicao;
    }
}
