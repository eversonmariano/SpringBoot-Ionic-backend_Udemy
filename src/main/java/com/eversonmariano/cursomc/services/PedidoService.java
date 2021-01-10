package com.eversonmariano.cursomc.services;

import com.eversonmariano.cursomc.domain.Pedido;
import com.eversonmariano.cursomc.repositories.PedidoRepository;
import com.eversonmariano.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repo;

    public Pedido find(Integer id) {
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "O pedido não foi encontrado através do Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }
}
