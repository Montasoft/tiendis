package com.tiendis.tiendis.Controllers;

import com.tiendis.tiendis.commons.ResponseHandler;
import com.tiendis.tiendis.entity.Banco;
import com.tiendis.tiendis.entity.Categoria;
import com.tiendis.tiendis.service.BancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value=  "api/banco")
public class BancoController {

    @Autowired
    private BancoService bancoService;

    @GetMapping(value = "/all")
    public List<Banco> getall() {
        return bancoService.getAll();
    }

    @PostMapping(value = "save")
    public ResponseEntity<Banco> save (@RequestBody Banco banco){
        Banco obj =bancoService.save(banco);
        return new ResponseEntity<Banco>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/find/{id}")
    public Banco find(@PathVariable Integer id){
        return bancoService.get(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    //public ResponseEntity<Banco> delete(@PathVariable Integer id){
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            Banco banco = bancoService.get((id));
            if (banco != null){
                bancoService.delete(id);
            }else {
                return ResponseHandler.generateResponse("No existe registro con el id indicado", HttpStatus.OK, null);
            }
            return ResponseHandler.generateResponse("Registro Eliminado con éxito", HttpStatus.OK, null);
        } catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
