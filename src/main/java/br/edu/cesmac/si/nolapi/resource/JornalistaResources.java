package br.edu.cesmac.si.nolapi.resource;

import br.edu.cesmac.si.nolapi.domain.Editoria;
import br.edu.cesmac.si.nolapi.domain.Jornalista;
import br.edu.cesmac.si.nolapi.repository.EditoriaRepository;
import br.edu.cesmac.si.nolapi.repository.JornalistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jornalistas")
public class JornalistaResources {

    @Autowired
    private JornalistaRepository jornalistaRepository;

    @GetMapping(path="/{id}")
    public ResponseEntity<Jornalista> buscarPorId(@PathVariable("id") Long idJornalista){
        return jornalistaRepository.findById(idJornalista).map(jornalista -> ResponseEntity.ok(jornalista)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Jornalista jornalista){
        jornalistaRepository.save(jornalista);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(jornalista.getIdJornalista()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public void alterar(@RequestBody Jornalista jornalista){
        jornalistaRepository.save(jornalista);
    }

    @DeleteMapping
    public void deletar(@RequestBody Jornalista jornalista){
        jornalistaRepository.delete(jornalista);
    }

    @GetMapping
    public List<Jornalista> buscarPorId(){
        return jornalistaRepository.findAll();
    }
}
