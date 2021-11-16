package com.tiendis.tiendis.Controllers;


import com.tiendis.tiendis.entity.Cliente;
import com.tiendis.tiendis.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable Integer id){
        Cliente cliente = clienteService.get(id);
        if (cliente != null){
            clienteService.delete(id);
        }else{
            return new ResponseEntity<Cliente>(cliente, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK) ;
    }

}
