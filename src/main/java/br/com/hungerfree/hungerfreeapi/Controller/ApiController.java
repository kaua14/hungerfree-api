package br.com.hungerfree.hungerfreeapi.Controller;

import br.com.hungerfree.hungerfreeapi.Model.Doacao;
import br.com.hungerfree.hungerfreeapi.Model.PontoDistribuicao;
import br.com.hungerfree.hungerfreeapi.Model.Colaborador;
import br.com.hungerfree.hungerfreeapi.Model.ColaboradorLogin;
import br.com.hungerfree.hungerfreeapi.Service.DoacaoService;
import br.com.hungerfree.hungerfreeapi.Service.PontoDistribuicaoService;
import br.com.hungerfree.hungerfreeapi.Service.ColaboradorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final ColaboradorService colaboradorService;
    private final PontoDistribuicaoService pontoDistribuicaoService;
    private final DoacaoService doacaoService;

    public ApiController(
            ColaboradorService colaboradorService,
            PontoDistribuicaoService pontoDistribuicaoService,
            DoacaoService doacaoService) {
        this.colaboradorService = colaboradorService;
        this.pontoDistribuicaoService = pontoDistribuicaoService;
        this.doacaoService = doacaoService;
    }

    @PostMapping("/usuarios")
    public ResponseEntity<String> cadastrarUsuario(@RequestBody Colaborador colaborador) {
        boolean colaboradorCadastrado = colaboradorService.cadastrarColaborador(colaborador);
        if (colaboradorCadastrado) {
            return ResponseEntity.ok("Colaborador cadastrado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Falha ao cadastrar colaborador.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> fazerLogin(@RequestBody ColaboradorLogin colaboradorLogin) {
        boolean colaboradorAutenticado = colaboradorService.autenticarColaborador(colaboradorLogin);
        if (colaboradorAutenticado) {
            return ResponseEntity.ok("Login realizado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Falha na autenticação. Verifique o email e senha.");
        }
    }

    @GetMapping("/pontos-distribuicao")
    public ResponseEntity<List<PontoDistribuicao>> listarPontosDistribuicao() {
        List<PontoDistribuicao> pontosDistribuicao = pontoDistribuicaoService.listarPontosDistribuicao();
        return ResponseEntity.ok(pontosDistribuicao);
    }

    @PostMapping("/doacoes")
    public ResponseEntity<String> cadastrarDoacao(@RequestBody Doacao doacao) {
        boolean doacaoCadastrada = doacaoService.cadastrarDoacao(doacao);
        if (doacaoCadastrada) {
            return ResponseEntity.ok("Doação cadastrada com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Falha ao cadastrar doação.");
        }
    }

    @PostMapping("/pontos-distribuicao")
    public ResponseEntity<String> cadastrarPontoDistribuicao(@RequestBody PontoDistribuicao pontoDistribuicao) {
        boolean pontoDistribuicaoCadastrado = pontoDistribuicaoService.cadastrarPontoDistribuicao(pontoDistribuicao);
        if (pontoDistribuicaoCadastrado) {
            return ResponseEntity.ok("Ponto de distribuição cadastrado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Falha ao cadastrar ponto de distribuição.");
        }
    }

    @PostMapping("/pontos-distribuicao/{id}/doacoes")
    public ResponseEntity<String> cadastrarDoacaoPontoDistribuicao(
            @PathVariable("id") Long pontoDistribuicaoId,
            @RequestBody Doacao doacao) {
        boolean doacaoCadastradaPontoDistribuicao =
                pontoDistribuicaoService.cadastrarDoacaoPontoDistribuicao(pontoDistribuicaoId, doacao);
        if (doacaoCadastradaPontoDistribuicao) {
            return ResponseEntity.ok("Doação cadastrada com sucesso no ponto de distribuição!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Falha ao cadastrar doação no ponto de distribuição.");
        }
    }

    @GetMapping("/doacoes")
    public ResponseEntity<List<Doacao>> listarDoacoes() {
        List<Doacao> doacoes = doacaoService.listarDoacoes();
        return ResponseEntity.ok(doacoes);
    }

    @GetMapping("/pontos-distribuicao/{id}/doacoes")
    public ResponseEntity<List<Doacao>> listarDoacoesPorPontoDistribuicao(
            @PathVariable("id") Long pontoDistribuicaoId) {
        List<Doacao> doacoes = doacaoService.listarDoacoesPorPontoDistribuicao(pontoDistribuicaoId);
        return ResponseEntity.ok(doacoes);
    }
}