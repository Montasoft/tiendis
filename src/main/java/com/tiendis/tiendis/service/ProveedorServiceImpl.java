package com.tiendis.tiendis.service;

import com.tiendis.tiendis.DAO.ProveedorDAO;
import com.tiendis.tiendis.commons.GenericServiceImpl;
import com.tiendis.tiendis.entity.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProveedorServiceImpl extends GenericServiceImpl<Proveedor, Long> implements ProveedorService {

    @Autowired
    private ProveedorDAO proveedorDAO;

    @Override
    public CrudRepository<Proveedor, Long> getDao() {
        return proveedorDAO;
    }
}
