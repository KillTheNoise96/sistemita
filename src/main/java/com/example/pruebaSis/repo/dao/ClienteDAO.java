package com.example.pruebaSis.repo.dao;

import com.example.pruebaSis.modelo.dto.Cliente;

import java.util.List;

public interface ClienteDAO {

    List<Cliente> obtenerTodos();

    Cliente obtenerPorId(Integer id);

    Cliente guardar(Cliente cliente);

    void eliminar(Integer id);
}
