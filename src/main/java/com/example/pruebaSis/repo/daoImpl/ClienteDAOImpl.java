package com.example.pruebaSis.repo.daoImpl;

import com.example.pruebaSis.mapper.ClienteMapper;
import com.example.pruebaSis.modelo.dto.Cliente;
import com.example.pruebaSis.repo.dao.ClienteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class ClienteDAOImpl implements ClienteDAO {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    public ClienteDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Cliente> obtenerTodos() {
        return jdbcTemplate.query("select * from clientes_ronny", new ClienteMapper());
    }

    @Override
    public Cliente obtenerPorId(Integer id) {
        return jdbcTemplate.query("select * from clientes_ronny where id = ?", new ClienteMapper(), id).
                stream().findFirst().orElse(null);
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("clientes_ronny").usingGeneratedKeyColumns("id");
        Map<String, Object> params = new HashMap<>();
        params.put("PRIMER_NOMBRE", cliente.getPrimNombre());
        params.put("SEGUNDO_NOMBRE", cliente.getSegNombre());
        params.put("PRIMER_APELLIDO", cliente.getPrimApellido());
        params.put("SEGUNDO_APELLIDO", cliente.getSegApellido());
        params.put("SEXO", cliente.getGenero());
        params.put("CELULAR", cliente.getTelefono());
        Integer id = simpleJdbcInsert.executeAndReturnKey(params).intValue();
        cliente = obtenerPorId(id);
        return cliente;
    }

    @Override
    public void eliminar(Integer id) {
        jdbcTemplate.update("delete from clientes_ronny where id = ?", id);
    }
}
