package com.isaias.controller;

import com.isaias.exception.ModelNotFoundException;
import com.isaias.model.Producto;
import com.isaias.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService service;

    @GetMapping
    public ResponseEntity<List<Producto>> listar(){
        List<Producto> productos = service.listar();
        return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> leerPorId(@PathVariable("id")Integer id){
        Producto producto = service.leer(id);
        return new ResponseEntity<Object>(producto,HttpStatus.OK); //200
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Producto producto){
        Producto p = service.registrar(producto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdProducto()).toUri();
        return ResponseEntity.created(location).build(); //201
    }

    @PutMapping
    public ResponseEntity<Object> modificar(@Valid @RequestBody Producto producto){
        service.modificar(producto);
        return new ResponseEntity<Object>(HttpStatus.OK); //201
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        Producto p = service.leer(id);
        if (p == null) {
            throw new ModelNotFoundException("ID NO ENCONTRADO: " + id);
        } else {
            service.eliminar(id);
        }
        return new ResponseEntity<Object>(HttpStatus.OK); //204
    }
}
