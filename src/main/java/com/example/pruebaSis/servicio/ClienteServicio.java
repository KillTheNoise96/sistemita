package com.example.pruebaSis.servicio;

import com.example.pruebaSis.mapper.ClienteMapper;
import com.example.pruebaSis.modelo.dto.Cliente;
import com.example.pruebaSis.repo.dao.ClienteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClienteServicio {

    private ClienteDAO clienteDAO;

    @Autowired
    public ClienteServicio(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public List<Cliente> obtenerTodos() {
        return clienteDAO.obtenerTodos();
    }

    public Cliente obtenerPorId(Integer id) {
        return clienteDAO.obtenerPorId(id);
    }

    public Cliente guardar(Cliente cliente) {
        return clienteDAO.guardar(cliente);
    }

    public void eliminar(Integer id) {
        clienteDAO.eliminar(id);
    }
}
