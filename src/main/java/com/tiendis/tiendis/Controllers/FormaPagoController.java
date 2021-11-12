package com.tiendis.tiendis.Controllers;

import com.tiendis.tiendis.entity.FormaPago;
import com.tiendis.tiendis.service.FormaPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.Normalizer;
import java.util.List;

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
    public FormaPago find(@PathVariable Long id) {
        return formaPagoService.get(id);
    }

    @PostMapping(value= "/delete/{id}")
    public ResponseEntity<FormaPago> delete(@PathVariable Long id) {
        FormaPago formaPago = formaPagoService.get((id));
        if (formaPago != null){
            formaPagoService.delete(id);
        }else{
            return new ResponseEntity<FormaPago>(formaPago, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<FormaPago>(formaPago, HttpStatus.OK);
    }
}
