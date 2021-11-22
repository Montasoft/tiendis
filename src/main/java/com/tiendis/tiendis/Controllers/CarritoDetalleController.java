package com.tiendis.tiendis.Controllers;

import com.tiendis.tiendis.commons.ResponseHandler;
import com.tiendis.tiendis.entity.CarritoDetalle;
import com.tiendis.tiendis.entity.Categoria;
import com.tiendis.tiendis.service.CarritoDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public CarritoDetalle find(@PathVariable Integer id){
        return carritoDetalleService.get(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            CarritoDetalle carritoDetalle = carritoDetalleService.get((id));
            if (carritoDetalle != null){
                carritoDetalleService.delete(id);
            }else {
                return ResponseHandler.generateResponse("No existe registro con el id indicado", HttpStatus.OK, null);
            }
            return ResponseHandler.generateResponse("Registro Eliminado con éxito", HttpStatus.OK, null);
        } catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
