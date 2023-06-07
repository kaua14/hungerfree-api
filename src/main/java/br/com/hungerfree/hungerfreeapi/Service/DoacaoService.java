package br.com.hungerfree.hungerfreeapi.Service;

import br.com.hungerfree.hungerfreeapi.Repository.DoacaoRepository;
import br.com.hungerfree.hungerfreeapi.Model.Doacao;
import br.com.hungerfree.hungerfreeapi.Repository.DoacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoacaoService {

    private final DoacaoRepository doacaoRepository;

    public DoacaoService(DoacaoRepository doacaoRepository) {
        this.doacaoRepository = doacaoRepository;
    }

    public boolean cadastrarDoacao(Doacao doacao) {
        try {
            doacaoRepository.save(doacao);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Doacao> listarDoacoes() {
        return doacaoRepository.findAll();
    }

    public List<Doacao> listarDoacoesPorPontoDistribuicao(Long pontoDistribuicaoId) {
        return doacaoRepository.findByPontoDistribuicaoId(pontoDistribuicaoId);
    }
}


