package com.tiendis.tiendis.Controllers;

import com.tiendis.tiendis.commons.ResponseHandler;
import com.tiendis.tiendis.entity.Categoria;
import com.tiendis.tiendis.entity.TipoCliente;
import com.tiendis.tiendis.entity.TipoCuenta;
import com.tiendis.tiendis.service.TipoClienteService;
import com.tiendis.tiendis.service.TipoCuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            TipoCliente tipoCliente = tipoClienteService.get((id));
            if (tipoCliente != null){
                tipoClienteService.delete(id);
            }else {
                return ResponseHandler.generateResponse("No existe registro con el id indicado", HttpStatus.OK, null);
            }
            return ResponseHandler.generateResponse("Registro Eliminado con éxito", HttpStatus.OK, null);
        } catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
