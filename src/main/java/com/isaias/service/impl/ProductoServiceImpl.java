package com.isaias.service.impl;

import com.isaias.model.Producto;
import com.isaias.repo.IProductoRepository;
import com.isaias.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private IProductoRepository repo;

    @Override
    public Producto registrar(Producto producto) {
        return repo.save(producto);
    }

    @Override
    public Producto modificar(Producto producto) {
        return repo.save(producto);
    }

    @Override
    public Producto leer(Integer id) {
        return repo.findOne(id);
    }

    @Override
    public List<Producto> listar() {
        return repo.findAll();
    }

    @Override
    public void eliminar(Integer id) {
        repo.delete(id);
    }
}
