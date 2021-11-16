package com.tiendis.tiendis.Controllers;

import com.tiendis.tiendis.entity.TipoComercio;
import com.tiendis.tiendis.service.TipoComercioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/tcomer/")
public class TipoComercioController {

    @Autowired
    private TipoComercioService tipoComercioService;

    @GetMapping(value = "/all")
    public List<TipoComercio> getAll(){
        return tipoComercioService.getAll();
    }

    @PostMapping(value = "/save")
    public ResponseEntity<TipoComercio> save(@RequestBody TipoComercio tipoComercio){
        TipoComercio obj = tipoComercioService.save(tipoComercio);
        return new ResponseEntity<TipoComercio>(obj, HttpStatus.OK);
    }
    @GetMapping(value = "/find/{id}")
    public TipoComercio find(@PathVariable Integer id) {
        return tipoComercioService.get(id);
    }

    @PostMapping(value= "/delete/{id}")
    public ResponseEntity<TipoComercio> delete(@PathVariable Integer id) {
        TipoComercio tipoComercio = tipoComercioService.get((id));
        if (tipoComercio != null){
            tipoComercioService.delete(id);
        }else{
            return new ResponseEntity<TipoComercio>(tipoComercio, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<TipoComercio>(tipoComercio, HttpStatus.OK);
    }
}
