package com.tiendis.tiendis.Controllers;

import com.tiendis.tiendis.entity.TipoCuenta;
import com.tiendis.tiendis.service.TipoCuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/tipocuen/")
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
    public TipoCuenta find(@PathVariable Long id) {
        return tipoCuentaService.get(id);
    }

    @PostMapping(value= "/delete/{id}")
    public ResponseEntity<TipoCuenta> delete(@PathVariable Long id) {
        TipoCuenta tipoCuenta = tipoCuentaService.get((id));
        if (tipoCuenta != null){
            tipoCuentaService.delete(id);
        }else{
            return new ResponseEntity<TipoCuenta>(tipoCuenta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<TipoCuenta>(tipoCuenta, HttpStatus.OK);
    }
}
