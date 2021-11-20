package com.tiendis.tiendis.Controllers;


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
    public ResponseEntity<String> delete(@PathVariable Integer id){
        Map<String, Object> map = new HashMap<>();
        Cliente cliente = clienteService.get(id);
        if (cliente != null){
            clienteService.delete(id);
        }else{
            map.put("Error", "No existe registro con el id indicado");
            return new ResponseEntity<String>(map.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        map.put("success", "\"Registro eliminado con éxito\"" );
        return new ResponseEntity<String>(map.toString(), HttpStatus.OK) ;
    }

}
