package com.example.pruebaSis.modelo.dto;

import lombok.Data;

@Data
public class Cliente{
    private Integer idCliente;
    private String primNombre;
    private String segNombre;
    private String primApellido;
    private String segApellido;
    private String genero;
    private Integer telefono;
}
