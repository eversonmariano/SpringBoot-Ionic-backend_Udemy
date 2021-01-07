package com.eversonmariano.cursomc.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eversonmariano.cursomc.domain.Categoria;
import com.eversonmariano.cursomc.repositories.CategoriaRepository;
import com.eversonmariano.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class CategoriaService {
  @Autowired
  private CategoriaRepository repo;
  public Categoria find(Integer id) {
    Optional<Categoria> obj = repo.findById(id);
    return obj.orElseThrow(() -> new ObjectNotFoundException(
            "A categoria não foi encontrada através do Id: " + id + ", Tipo: " + Categoria.class.getName()));
  }
}
