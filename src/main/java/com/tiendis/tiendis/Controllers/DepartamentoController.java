package com.tiendis.tiendis.Controllers;

import com.tiendis.tiendis.entity.Ciudad;
import com.tiendis.tiendis.entity.Departamento;
import com.tiendis.tiendis.service.CiudadService;
import com.tiendis.tiendis.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/departamento/")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping(value = "/all")
    public List<Departamento> getAll(){
        return departamentoService.getAll();
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Departamento> save(@RequestBody Departamento departamento){
        Departamento obj = departamentoService.save(departamento);
        return new ResponseEntity<Departamento>(obj, HttpStatus.OK);
    }
    @GetMapping(value = "/find/{id}")
    public Departamento find(@PathVariable String id) {
        return departamentoService.get(id);
    }

    @DeleteMapping(value= "/delete/{id}")
    public ResponseEntity<Departamento> delete(@PathVariable String id) {
        Departamento departamento = departamentoService.get((id));
        if (departamento != null){
            departamentoService.delete(id);
        }else{
            return new ResponseEntity<Departamento>(departamento, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Departamento>(departamento, HttpStatus.OK);
    }
}
