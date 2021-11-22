package com.tiendis.tiendis.Controllers;

import com.tiendis.tiendis.commons.ResponseHandler;
import com.tiendis.tiendis.entity.Categoria;
import com.tiendis.tiendis.entity.CuentaBancaria;
import com.tiendis.tiendis.service.CuentaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            CuentaBancaria cuentaBancaria = cuentaBancariaService.get((id));
            if (cuentaBancaria != null){
                cuentaBancariaService.delete(id);
            }else {
                return ResponseHandler.generateResponse("No existe registro con el id indicado", HttpStatus.OK, null);
            }
            return ResponseHandler.generateResponse("Registro Eliminado con éxito", HttpStatus.OK, null);
        } catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }}