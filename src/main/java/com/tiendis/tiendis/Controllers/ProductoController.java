package com.tiendis.tiendis.Controllers;

import com.tiendis.tiendis.DAO.ProductoDAO;
import com.tiendis.tiendis.commons.ResponseHandler;
import com.tiendis.tiendis.entity.Producto;
import com.tiendis.tiendis.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping(value = "/api/prod/")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private  ProductoDAO productoDAO;

    @GetMapping(value = "/all")
    public List<Producto> getAll(){
        return productoService.getAll();
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Producto> save(@RequestBody Producto producto){
        Producto obj = productoService.save(producto);
        return new ResponseEntity<Producto>(obj, HttpStatus.OK);
    }
    @GetMapping(value = "/find/{id}")
    public Producto find(@PathVariable Integer id) {
        return productoService.get(id);
    }

    @DeleteMapping(value= "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            Producto producto = productoService.get((id));
            if (producto != null){
                productoService.delete(id);
            }else {
                return ResponseHandler.generateResponse("No existe registro con el id indicado", HttpStatus.OK, null);
            }
            return ResponseHandler.generateResponse("Registro Eliminado con éxito", HttpStatus.OK, null);
        } catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
    @GetMapping(value= "/pageable")
    List<Producto> getProductoPageable(@RequestParam int page, @RequestParam int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Producto> productoPage = productoService.getAll(pageRequest);

//        ProductoDAO productoDAO = getProductoPageable(page, size);
        return productoService.getAll(PageRequest.of(page, size)).getContent();
    }
    /*
    public String findAll(@RequestParam Map<String, Object> params, Model model){
        int page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString())-1) :0;

        PageRequest pageRequest = PageRequest.of(page, 10);
        Page<Producto> productoPage = productoService.getAll(pageRequest);
        int totalPages = productoPage.getTotalPages();
        if (totalPages >0){
            List<Integer> pages = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
        }
        model.addAttribute ("list", productoPage.getContent());
        return productoPage;
    }

     */
}
