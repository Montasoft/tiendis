package com.tiendis.tiendis.Controllers;


import com.tiendis.tiendis.commons.ResponseHandler;
import com.tiendis.tiendis.entity.Categoria;
import com.tiendis.tiendis.entity.Cliente;
import com.tiendis.tiendis.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value=  "api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/all")
    public List<Cliente> getall() {
        return clienteService.getAll();
    }

    @PostMapping(value = "save")
    public ResponseEntity<Cliente> save (@RequestBody Cliente cliente){
        Cliente obj =clienteService.save(cliente);
        return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/find/{id}")
    public Cliente find(@PathVariable Integer id){
        return clienteService.get(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            Cliente cliente = clienteService.get((id));
            if (cliente != null){
                clienteService.delete(id);
            }else {
                return ResponseHandler.generateResponse("No existe registro con el id indicado", HttpStatus.OK, null);
            }
            return ResponseHandler.generateResponse("Registro Eliminado con éxito", HttpStatus.OK, null);
        } catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }}
