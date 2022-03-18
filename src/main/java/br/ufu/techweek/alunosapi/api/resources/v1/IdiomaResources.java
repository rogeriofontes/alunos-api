package br.ufu.techweek.alunosapi.api.resources.v1;

import br.ufu.techweek.alunosapi.model.domain.Idioma;
import br.ufu.techweek.alunosapi.model.service.IdiomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/idiomas")
public class IdiomaResources {

    @Autowired
    private IdiomaService idiomaService;

    @GetMapping
    public ResponseEntity<List<Idioma>> pegarTodos() {
        List<Idioma> idiomas = idiomaService.list();

        if (!idiomas.isEmpty()) {
           return ResponseEntity.ok(idiomas);
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Idioma> pegarPorId(@PathVariable("id") Long id) {
        Optional<Idioma> idiomas = idiomaService.findById(id);

        if (idiomas.isPresent()) {
            return ResponseEntity.ok(idiomas.get());
        }

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Idioma> salvar(@RequestBody Idioma idioma) {
        Idioma idiomaRetornado = idiomaService.salvar(idioma);

        if (idiomaRetornado != null) {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(idiomaRetornado.getId()).toUri();
            return ResponseEntity.created(uri).body(idiomaRetornado);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Idioma> salvar(@PathVariable("id") Long id, @RequestBody Idioma idioma) {
        Idioma idiomaRetornado = idiomaService.editar(id, idioma);

        if (idiomaRetornado != null) {
            return ResponseEntity.ok(idioma);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        idiomaService.delete(id);
        return ResponseEntity.ok().build();
    }


}
