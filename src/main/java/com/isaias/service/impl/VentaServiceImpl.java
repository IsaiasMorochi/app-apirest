package com.isaias.service.impl;

import com.isaias.model.DetalleVenta;
import com.isaias.model.Producto;
import com.isaias.model.Venta;
import com.isaias.repo.IVentaRepository;
import com.isaias.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServiceImpl implements IVentaService {

    @Autowired
    private IVentaRepository repo;

    @Override
    public Venta registrar(Venta venta) {

        Producto p = new Producto();
        p.setIdProducto(1);

        venta.getDetalleVenta().forEach(detalle -> detalle.setVenta(venta));
        return repo.save(venta);
    }

    @Override
    public Venta modificar(Venta venta) {
        return repo.save(venta);
    }

    @Override
    public Venta leer(Integer id) {
        return repo.findOne(id);
    }

    @Override
    public List<Venta> listar() {
        return repo.findAll();
    }

    @Override
    public void eliminar(Integer id) {
        repo.delete(id);
    }
}
