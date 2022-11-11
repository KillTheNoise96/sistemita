package com.example.pruebaSis.vista;

import com.example.pruebaSis.modelo.dto.Cliente;
import com.example.pruebaSis.servicio.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteControlador {

    private ClienteServicio clienteServicio;

    @Autowired
    public ClienteControlador(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Cliente>> obtenerTodo() {
        return new ResponseEntity<>(clienteServicio.obtenerTodos(), HttpStatus.OK);
    }

    @GetMapping("/lista/{id}")
    public ResponseEntity<Cliente> obtenerPorId(@PathVariable Integer id) {
        Cliente cliente = clienteServicio.obtenerPorId(id);
        return cliente != null ?
                new ResponseEntity<>(cliente, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<Cliente> guardar(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteServicio.guardar(cliente), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id) {
        clienteServicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
