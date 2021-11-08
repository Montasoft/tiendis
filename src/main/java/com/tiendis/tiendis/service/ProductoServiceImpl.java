package com.tiendis.tiendis.service;

import com.tiendis.tiendis.DAO.ProductoDAO;
import com.tiendis.tiendis.commons.GenericServiceImpl;
import com.tiendis.tiendis.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends GenericServiceImpl<Producto, Long> implements ProductoService {

    @Autowired
    private ProductoDAO productoDAO;


    @Override
    public CrudRepository<Producto, Long> getDao() {
        return productoDAO;
    }
}
