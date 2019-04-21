package com.isaias.controller;

import com.isaias.exception.ModelNotFoundException;
import com.isaias.model.Persona;
import com.isaias.service.IPersonaService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private IPersonaService service;

    @GetMapping
    public ResponseEntity<List<Persona>> listar(){
        List<Persona> personas = service.listar();
        return new ResponseEntity<List<Persona>>(personas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> leerPorId(@PathVariable("id")Integer id){
        Persona persona = service.leer(id);
        return new ResponseEntity<Object>(persona, HttpStatus.OK); //200
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Persona persona){
        Persona p = service.registrar(persona);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdPersona()).toUri();
        return ResponseEntity.created(location).build(); //201
    }

    @PutMapping
    public ResponseEntity<Object> modificar(@Valid @RequestBody Persona persona){
        service.modificar(persona);
        return new ResponseEntity<Object>(HttpStatus.OK); //201
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        Persona p = service.leer(id);
        if (p == null) {
            throw new ModelNotFoundException("ID NO ENCONTRADO: " + id);
        } else {
            service.eliminar(id);
        }
        return new ResponseEntity<Object>(HttpStatus.OK); //204
    }
}
