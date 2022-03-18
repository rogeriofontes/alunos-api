package br.ufu.techweek.alunosapi.api.resources.v1;

import br.ufu.techweek.alunosapi.model.domain.Vaga;
import br.ufu.techweek.alunosapi.model.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vagas")
public class VagaResources {

    @Autowired
    private VagaService vagaService;

    @GetMapping
    public ResponseEntity<List<Vaga>> pegarTodos() {
        List<Vaga> vagas = vagaService.list();

        if (vagas != null) {
           return ResponseEntity.ok(vagas);
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vaga> pegarPorId(@PathVariable("id") Long id) {
        Optional<Vaga> vagas = vagaService.findById(id);

        if (vagas.isPresent()) {
           return ResponseEntity.ok(vagas.get());
        }

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Vaga> salvar(@RequestBody Vaga vaga) {
        Vaga vagaRetornado = vagaService.salvar(vaga);

        if (vagaRetornado != null) {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vagaRetornado.getId()).toUri();
            return ResponseEntity.created(uri).body(vagaRetornado);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vaga> salvar(@PathVariable("id") Long id, @RequestBody Vaga vaga) {
        Vaga vagaRetornado = vagaService.editar(id, vaga);

        if (vagaRetornado != null) {
            return ResponseEntity.ok(vaga);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        vagaService.delete(id);
        return ResponseEntity.ok().build();
    }

}
