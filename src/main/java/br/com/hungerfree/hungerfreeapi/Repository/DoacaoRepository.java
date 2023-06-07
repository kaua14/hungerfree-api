package br.com.hungerfree.hungerfreeapi.Repository;

import br.com.hungerfree.hungerfreeapi.Model.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoacaoRepository extends JpaRepository<Doacao, Long> {
    List<Doacao> findByPontoDistribuicaoId(Long pontoDistribuicaoId);
    // Nenhum método adicional necessário no momento
}

