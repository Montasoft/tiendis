package com.tiendis.tiendis.Controllers;

import com.tiendis.tiendis.entity.CarritoDetalle;
import com.tiendis.tiendis.service.CarritoDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value=  "api/carrdetal")
public class CarritoDetalleController {

    @Autowired
    private CarritoDetalleService carritoDetalleService;

    @GetMapping(value = "/all")
    public List<CarritoDetalle> getall() {
        return carritoDetalleService.getAll();
    }

    @PostMapping(value = "save")
    public ResponseEntity<CarritoDetalle> save (@RequestBody CarritoDetalle carritoDetalle){
        CarritoDetalle obj =carritoDetalleService.save(carritoDetalle);
        return new ResponseEntity<CarritoDetalle>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/find/{id}")
    public CarritoDetalle find(@PathVariable Long id){
        return carritoDetalleService.get(id);
    }

    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<CarritoDetalle> delete(@PathVariable Long id){
        CarritoDetalle carritoDetalle = carritoDetalleService.get(id);
        if (carritoDetalle != null){
            carritoDetalleService.delete(id);
        }else{
            return new ResponseEntity<CarritoDetalle>(carritoDetalle, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CarritoDetalle>(carritoDetalle, HttpStatus.OK) ;
    }

}
