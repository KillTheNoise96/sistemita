package com.example.pruebaSis.mapper;

import com.example.pruebaSis.modelo.dto.Cliente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteMapper implements RowMapper<Cliente> {
    @Override
    public Cliente mapRow(ResultSet rs, int numRow) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(rs.getInt("id"));
        cliente.setPrimNombre(rs.getString("PRIMER_NOMBRE"));
        cliente.setSegNombre(rs.getString("SEGUNDO_NOMBRE"));
        cliente.setPrimApellido(rs.getString("PRIMER_APELLIDO"));
        cliente.setSegApellido(rs.getString("SEGUNDO_APELLIDO"));
        cliente.setGenero(rs.getString("SEXO"));
        cliente.setTelefono(rs.getInt("CELULAR"));
        return cliente;
    }
}
