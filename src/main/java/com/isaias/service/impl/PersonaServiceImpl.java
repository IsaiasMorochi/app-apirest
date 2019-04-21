package com.isaias.service.impl;

import com.isaias.model.Persona;
import com.isaias.repo.IPersonaRepository;
import com.isaias.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    private IPersonaRepository repo;

    @Override
    public Persona registrar(Persona persona) {
        return repo.save(persona);
    }

    @Override
    public Persona modificar(Persona persona) {
        return repo.save(persona);
    }

    @Override
    public Persona leer(Integer id) {
        return repo.findOne(id);
    }

    @Override
    public List<Persona> listar() {
        return repo.findAll();
    }

    @Override
    public void eliminar(Integer id) {
        repo.delete(id);
    }
}
