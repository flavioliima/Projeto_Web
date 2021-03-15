package br.edu.cesmac.si.nolapi.resource;

import br.edu.cesmac.si.nolapi.domain.Editoria;
import br.edu.cesmac.si.nolapi.domain.Jornalista;
import br.edu.cesmac.si.nolapi.repository.EditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/editorias")
public class EditoriaResources {

    @Autowired
    private EditoriaRepository editoriaRepository;

    @GetMapping(value="/{id}")
    public ResponseEntity<Editoria> buscarPorId(@PathVariable("id") Long idEditoria){
        return editoriaRepository.findById(idEditoria).map(editoria -> ResponseEntity.ok(editoria)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Editoria editoria){
        editoriaRepository.save(editoria);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(editoria.getIdEditoria()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public void alterar(@RequestBody Editoria editoria){
        editoriaRepository.save(editoria);
    }

    @DeleteMapping
    public void deletar(@RequestBody Editoria editoria){
        editoriaRepository.delete(editoria);
    }
}
