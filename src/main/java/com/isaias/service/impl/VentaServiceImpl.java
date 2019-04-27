package com.isaias.service.impl;

import com.isaias.dto.VentaListaDetalleDTO;

import com.isaias.model.Venta;
import com.isaias.repo.IDetalleVentaRepository;
import com.isaias.repo.IVentaRepository;
import com.isaias.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VentaServiceImpl implements IVentaService {

    @Autowired
    private IVentaRepository repo;


    @Autowired
    private IDetalleVentaRepository repoDV;

    @Transactional
    @Override
    public Venta registrarTransaccional(VentaListaDetalleDTO ventaDTO) {
        repo.save(ventaDTO.getVenta());

        ventaDTO.getDetalleVenta().forEach(e -> repoDV.registrar(  ventaDTO.getVenta().getIdVenta(), e.getIdProducto(), ventaDTO.getCantidad()) );
        return ventaDTO.getVenta();
    }

    @Override
    public Venta registrar(Venta venta) {
//        venta.getDetalleVenta().forEach(detalle -> detalle.setIdVenta(venta));
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
