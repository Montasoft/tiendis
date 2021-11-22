package com.tiendis.tiendis.Controllers;

import com.tiendis.tiendis.commons.ResponseHandler;
import com.tiendis.tiendis.entity.Categoria;
import com.tiendis.tiendis.entity.FormaPago;
import com.tiendis.tiendis.service.FormaPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/forpag/")
public class FormaPagoController {

    @Autowired
    private FormaPagoService formaPagoService;

    @GetMapping(value = "/all")
    public List<FormaPago> getAll(){
        return formaPagoService.getAll();
    }

    @PostMapping(value = "/save")
    public ResponseEntity<FormaPago> save(@RequestBody FormaPago formaPago){
        FormaPago obj = formaPagoService.save(formaPago);
        return new ResponseEntity<FormaPago>(obj, HttpStatus.OK);
    }
    @GetMapping(value = "/find/{id}")
    public FormaPago find(@PathVariable Integer id) {
        return formaPagoService.get(id);
    }

    @DeleteMapping(value= "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            FormaPago formaPago = formaPagoService.get((id));
            if (formaPago != null){
                formaPagoService.delete(id);
            }else {
                return ResponseHandler.generateResponse("No existe registro con el id indicado", HttpStatus.OK, null);
            }
            return ResponseHandler.generateResponse("Registro Eliminado con éxito", HttpStatus.OK, null);
        } catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }}
