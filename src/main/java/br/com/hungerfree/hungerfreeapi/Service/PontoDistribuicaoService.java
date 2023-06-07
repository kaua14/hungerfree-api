package br.com.hungerfree.hungerfreeapi.Service;

import br.com.hungerfree.hungerfreeapi.Model.Doacao;
import br.com.hungerfree.hungerfreeapi.Model.PontoDistribuicao;
import br.com.hungerfree.hungerfreeapi.Repository.PontoDistribuicaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PontoDistribuicaoService {

    private final PontoDistribuicaoRepository pontoDistribuicaoRepository;

    public PontoDistribuicaoService(PontoDistribuicaoRepository pontoDistribuicaoRepository) {
        this.pontoDistribuicaoRepository = pontoDistribuicaoRepository;
    }

    public boolean cadastrarPontoDistribuicao(PontoDistribuicao pontoDistribuicao) {
        try {
            pontoDistribuicaoRepository.save(pontoDistribuicao);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<PontoDistribuicao> listarPontosDistribuicao() {
        return pontoDistribuicaoRepository.findAll();
    }

    public boolean cadastrarDoacaoPontoDistribuicao(Long pontoDistribuicaoId, Doacao doacao) {
        Optional<PontoDistribuicao> optionalPontoDistribuicao = pontoDistribuicaoRepository.findById(pontoDistribuicaoId);
        if (optionalPontoDistribuicao.isPresent()) {
            PontoDistribuicao pontoDistribuicao = optionalPontoDistribuicao.get();
            pontoDistribuicao.getDoacoes().add(doacao);
            pontoDistribuicaoRepository.save(pontoDistribuicao);
            return true;
        } else {
            return false;
        }
    }
}