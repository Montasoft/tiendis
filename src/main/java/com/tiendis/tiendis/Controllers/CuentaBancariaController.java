package com.tiendis.tiendis.Controllers;

import com.tiendis.tiendis.entity.CuentaBancaria;
import com.tiendis.tiendis.service.CuentaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value=  "api/cuenta")
public class CuentaBancariaController {

    @Autowired
    private CuentaBancariaService cuentaBancariaService;

    @GetMapping(value = "/all")
    public List<CuentaBancaria> getall() {
        return cuentaBancariaService.getAll();
    }

    @PostMapping(value = "save")
    public ResponseEntity<CuentaBancaria> save (@RequestBody CuentaBancaria cuentaBancaria){
        CuentaBancaria obj =cuentaBancariaService.save(cuentaBancaria);
        return new ResponseEntity<CuentaBancaria>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/find/{id}")
    public CuentaBancaria find(@PathVariable Integer id){
        return cuentaBancariaService.get(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<CuentaBancaria> delete(@PathVariable Integer id){
        CuentaBancaria cuentaBancaria = cuentaBancariaService.get(id);
        if (cuentaBancaria != null){
            cuentaBancariaService.delete(id);
        }else{
            return new ResponseEntity<CuentaBancaria>(cuentaBancaria, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CuentaBancaria>(cuentaBancaria, HttpStatus.OK) ;
    }
}