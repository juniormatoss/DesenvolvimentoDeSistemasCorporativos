package br.ufpb.dcx.lab1v1.controller;

import br.ufpb.dcx.lab1v1.domain.disciplina.DadosCadastroDisciplina;
import br.ufpb.dcx.lab1v1.domain.disciplina.DadosDetalhamentoDisciplina;
import br.ufpb.dcx.lab1v1.domain.disciplina.Disciplina;
import br.ufpb.dcx.lab1v1.service.DisciplinaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RestController
@RequestMapping("/v1/api/disciplinas")
public class DisciplinaController {


    private final DisciplinaService disciplinaService;

    @Autowired
    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    //adicionar
    @PostMapping
    public ResponseEntity adicionar(@RequestBody DadosCadastroDisciplina dados, UriComponentsBuilder uriComponentsBuilder) {
        var disciplina = new Disciplina(dados);
        disciplinaService.adicionar(disciplina);
        var uri = uriComponentsBuilder.path("/v1/api/disciplinas/{id}").buildAndExpand(disciplina.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoDisciplina(disciplina));
    }

    @GetMapping

    
    public List<Disciplina> listar() {

        return disciplinaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity pegarPorId(@PathVariable int id) {
        var disciplinas = disciplinaService.listarDisciplina(id);

        return ResponseEntity.ok(new DadosDetalhamentoDisciplina(disciplinas));
    }

    @PutMapping
    public ResponseEntity atualizar(@PathVariable int id, @RequestBody Disciplina disciplina) {
        disciplinaService.atualizar(id, disciplina);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable int id) {
        disciplinaService.deletar(id);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/nota")
    public ResponseEntity<Disciplina> adicionarNotaDisciplina(
            @PathVariable int id,
            @RequestBody double nota) {

        Disciplina disciplina = disciplinaService.adicionarNota(id, nota);

        if (disciplina == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(disciplina);
    }

    @PostMapping("/{id}/like")
    public ResponseEntity darLike(@PathVariable int id, int like) {
        disciplinaService.adicionarLike(id, like);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/ranking")
    public ResponseEntity<List<Disciplina>> obterRankingDisciplinas() {
        List<Disciplina> ranking = disciplinaService.obterRankingDisciplinas();

        if (ranking.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(ranking);
    }

}
