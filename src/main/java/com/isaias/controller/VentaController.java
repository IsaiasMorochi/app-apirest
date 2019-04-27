package com.isaias.controller;

import com.isaias.dto.VentaListaDetalleDTO;
import com.isaias.exception.ModelNotFoundException;
import com.isaias.model.Venta;
import com.isaias.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private IVentaService service;

    @GetMapping
    public ResponseEntity<List<Venta>> listar(){
        List<Venta> ventas = service.listar();
        return new ResponseEntity<List<Venta>>(ventas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> leerPorId(@PathVariable("id")Integer id){
        Venta venta = service.leer(id);
        return new ResponseEntity<Object>(venta,HttpStatus.OK); //200
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody VentaListaDetalleDTO ventaDTO){
        Venta v = service.registrarTransaccional(ventaDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(v.getIdVenta()).toUri();
        return ResponseEntity.created(location).build(); //201
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> modificar(@Valid @RequestBody Venta venta){
        service.modificar(venta);
        return new ResponseEntity<Object>(HttpStatus.OK); //201
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        Venta p = service.leer(id);
        if (p == null) {
            throw new ModelNotFoundException("ID NO ENCONTRADO: " + id);
        } else {
            service.eliminar(id);
        }
        return new ResponseEntity<Object>(HttpStatus.OK); //204
    }
}
