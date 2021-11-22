package com.tiendis.tiendis.Controllers;

import com.tiendis.tiendis.commons.ResponseHandler;
import com.tiendis.tiendis.entity.Categoria;
import com.tiendis.tiendis.entity.TipoCuenta;
import com.tiendis.tiendis.service.TipoCuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/tcuen/")
public class TipoCuentaController {

    @Autowired
    private TipoCuentaService tipoCuentaService;

    @GetMapping(value = "/all")
    public List<TipoCuenta> getAll(){
        return tipoCuentaService.getAll();
    }

    @PostMapping(value = "/save")
    public ResponseEntity<TipoCuenta> save(@RequestBody TipoCuenta tipoCuenta){
        TipoCuenta obj = tipoCuentaService.save(tipoCuenta);
        return new ResponseEntity<TipoCuenta>(obj, HttpStatus.OK);
    }
    @GetMapping(value = "/find/{id}")
    public TipoCuenta find(@PathVariable Integer id) {
        return tipoCuentaService.get(id);
    }

    @DeleteMapping(value= "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            TipoCuenta tipoCuenta = tipoCuentaService.get((id));
            if (tipoCuenta != null){
                tipoCuentaService.delete(id);
            }else {
                return ResponseHandler.generateResponse("No existe registro con el id indicado", HttpStatus.OK, null);
            }
            return ResponseHandler.generateResponse("Registro Eliminado con éxito", HttpStatus.OK, null);
        } catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
