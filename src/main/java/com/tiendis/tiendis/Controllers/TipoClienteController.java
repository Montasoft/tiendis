package com.tiendis.tiendis.Controllers;

import com.tiendis.tiendis.entity.TipoCliente;
import com.tiendis.tiendis.entity.TipoCuenta;
import com.tiendis.tiendis.service.TipoClienteService;
import com.tiendis.tiendis.service.TipoCuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/tclien/")
public class TipoClienteController {

    @Autowired
    private TipoClienteService tipoClienteService;

    @GetMapping(value = "/all")
    public List<TipoCliente> getAll(){
        return tipoClienteService.getAll();
    }

    @PostMapping(value = "/save")
    public ResponseEntity<TipoCliente> save(@RequestBody TipoCliente tipoCliente){
        TipoCliente obj = tipoClienteService.save(tipoCliente);
        return new ResponseEntity<TipoCliente>(obj, HttpStatus.OK);
    }
    @GetMapping(value = "/find/{id}")
    public TipoCliente find(@PathVariable Integer id) {
        return tipoClienteService.get(id);
    }

    @DeleteMapping(value= "/delete/{id}")
    public ResponseEntity<TipoCliente> delete(@PathVariable Integer id) {
        TipoCliente tipoCliente = tipoClienteService.get((id));
        if (tipoCliente != null){
            tipoClienteService.delete(id);
        }else{
            return new ResponseEntity<TipoCliente>(tipoCliente, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<TipoCliente>(tipoCliente, HttpStatus.OK);
    }
}
