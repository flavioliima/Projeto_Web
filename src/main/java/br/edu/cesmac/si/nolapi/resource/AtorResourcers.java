package br.edu.cesmac.si.nolapi.resource;

import br.edu.cesmac.si.nolapi.domain.Ator;
import br.edu.cesmac.si.nolapi.repository.AtorRepository;
import br.edu.cesmac.si.nolapi.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/atores")
public class AtorResourcers {

    @Autowired
    private AtorRepository atorRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Ator> buscarPorId(@PathVariable("id") Long idAtor){
        return atorRepository.findById(idAtor).map(ator -> ResponseEntity.ok(ator)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Ator ator){
        atorRepository.save(ator);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ator.getIdAutor()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public void alterar(@RequestBody Ator ator){
        atorRepository.save(ator);
    }

    @DeleteMapping
    public void deletar(@RequestBody Ator ator){
        atorRepository.delete(ator);
    }
}
