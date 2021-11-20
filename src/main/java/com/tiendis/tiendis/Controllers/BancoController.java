package com.tiendis.tiendis.Controllers;

import com.tiendis.tiendis.entity.Banco;
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
    //public ResponseEntity<String> delete(@PathVariable Integer id){
    public ResponseEntity<String> delete(@PathVariable Integer id){
        Map<String, Object> map = new HashMap<>();
        Banco banco = bancoService.get(id);
        if (banco != null){
            bancoService.delete(id);
        }else{
            //return new ResponseEntity<Banco>(banco, HttpStatus.INTERNAL_SERVER_ERROR);
            map.put("Error", "No existe registro con el id indicado");
            return new ResponseEntity<String>(map.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //return new ResponseEntity<Banco>(banco, HttpStatus.OK) ;
        map.put("success", "\"Registro eliminado con éxito\"" );
        return new ResponseEntity<String>(map.toString(), HttpStatus.OK) ;

    }

}
