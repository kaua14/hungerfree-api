package br.com.hungerfree.hungerfreeapi.Repository;



import br.com.hungerfree.hungerfreeapi.Model.PontoDistribuicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontoDistribuicaoRepository extends JpaRepository<PontoDistribuicao, Long> {
    // Nenhum método adicional necessário no momento
}

