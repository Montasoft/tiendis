package com.tiendis.tiendis.service.Implement;

import com.tiendis.tiendis.DAO.ProductoDAO;
import com.tiendis.tiendis.commons.GenericServiceImpl;
import com.tiendis.tiendis.entity.Producto;
import com.tiendis.tiendis.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends GenericServiceImpl<Producto, Integer> implements ProductoService {

    @Autowired
    private ProductoDAO productoDAO;


    @Override
    public CrudRepository<Producto, Integer> getDao() {
        return productoDAO;
    }

    @Override
    public Page<Producto> getAll(Pageable pageable){
        return productoDAO.findAll(pageable);
    }
}
